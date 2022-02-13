package com.r3d1r4ph.catsinfo.feature.cats.data

import androidx.paging.PagingSource

interface CatsLocalDatasource {

    suspend fun insertAll(catEntities: List<CatEntity>)

    suspend fun clearAll()

    fun pagingSource(): PagingSource<Int, CatEntity>

    suspend fun getCatById(catId: String): CatEntity
}