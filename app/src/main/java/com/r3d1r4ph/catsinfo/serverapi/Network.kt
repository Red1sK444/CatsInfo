package com.r3d1r4ph.catsinfo.serverapi

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.r3d1r4ph.catsinfo.BuildConfig
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object Network {
    private const val BASE_URL = "https://api.thecatapi.com/"
    private val mediaType = "application/json".toMediaType()

    private val client = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val request = chain.request()
            val requestBuilder = request.newBuilder()
            //add an api key
            requestBuilder.addHeader("x-api-key", "9c2ceea3-c5a7-4f0a-8a66-cfa01d294f62")
            chain.proceed(requestBuilder.build())
        })
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
        })
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

    private val json = Json { ignoreUnknownKeys = true }

    @ExperimentalSerializationApi
    val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(mediaType))
        .build()
}