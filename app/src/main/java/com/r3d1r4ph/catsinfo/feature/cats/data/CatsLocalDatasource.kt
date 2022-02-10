package com.r3d1r4ph.catsinfo.feature.cats.data

import androidx.paging.PagingSource
import com.r3d1r4ph.catsinfo.database.CatEntity

interface CatsLocalDatasource {

    suspend fun insertAll(catEntities: List<CatEntity>)

    suspend fun clearAll()

    fun pagingSource(): PagingSource<Int, CatEntity>
}