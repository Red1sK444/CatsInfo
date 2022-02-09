package com.r3d1r4ph.catsinfo.serverapi.cats

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsInterface {

    @GET("v1/images/search")
    suspend fun cats(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<List<CatResponse>>
}