package com.r3d1r4ph.catsinfo.feature.cats.domain

import androidx.paging.PagingSource
import com.r3d1r4ph.catsinfo.database.CatEntity

interface CatsRepository {

    fun getAll(): PagingSource<Int, CatEntity>

    suspend fun insertAll(catEntities: List<CatEntity>)

    suspend fun clearAll()
}