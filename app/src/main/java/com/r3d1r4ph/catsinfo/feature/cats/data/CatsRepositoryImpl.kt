package com.r3d1r4ph.catsinfo.feature.cats.data

import androidx.paging.PagingSource
import com.r3d1r4ph.catsinfo.database.CatEntity
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatsRepository

class CatsRepositoryImpl : CatsRepository {

    override fun getAll(): PagingSource<Int, CatEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertAll(catEntities: List<CatEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun clearAll() {
        TODO("Not yet implemented")
    }
}