package com.r3d1r4ph.catsinfo.feature.cats.data

import androidx.paging.PagingSource
import com.r3d1r4ph.catsinfo.database.CatEntity
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatsRepository

class CatsRepositoryImpl(private val catsLocalDatasource: CatsLocalDatasource) : CatsRepository {

    override fun getAll(): PagingSource<Int, CatEntity> = catsLocalDatasource.pagingSource()

    override suspend fun insertAll(catEntities: List<CatEntity>) {
        catsLocalDatasource.insertAll(catEntities)
    }

    override suspend fun clearAll() {
        catsLocalDatasource.clearAll()
    }
}