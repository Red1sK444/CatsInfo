package com.r3d1r4ph.catsinfo.feature.cats.domain

import androidx.paging.PagingData
import com.r3d1r4ph.catsinfo.feature.cats.data.CatEntity
import kotlinx.coroutines.flow.Flow

interface CatsRepository {

    fun letCatsFlow(): Flow<PagingData<CatItem>>

    suspend fun insertAll(catEntities: List<CatEntity>)

    suspend fun clearAll()

    suspend fun getCatById(catId: String): CatEntity
}