package com.r3d1r4ph.catsinfo.feature.cats.data

import androidx.paging.*
import com.r3d1r4ph.catsinfo.database.AppDatabase
import com.r3d1r4ph.catsinfo.database.CatEntity
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatItem
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatsRepository
import com.r3d1r4ph.catsinfo.feature.cats.list.domain.ClearCatsUseCase
import com.r3d1r4ph.catsinfo.feature.cats.list.domain.InsertCatsUseCase
import com.r3d1r4ph.catsinfo.serverapi.cats.CatsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CatsRepositoryImpl(
    private val catsLocalDatasource: CatsLocalDatasource,
    private val database: AppDatabase
) : CatsRepository {

    override suspend fun insertAll(catEntities: List<CatEntity>) {
        catsLocalDatasource.insertAll(catEntities)
    }

    override suspend fun clearAll() {
        catsLocalDatasource.clearAll()
    }

    override suspend fun getCatById(catId: String) = catsLocalDatasource.getCatById(catId)

    @OptIn(ExperimentalPagingApi::class)
    override fun letCatsFlow(): Flow<PagingData<CatItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = CatsRemoteMediator.PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = CatsRemoteMediator(
                database = database,
                catsService = CatsService(),
                clearCatsUseCase = ClearCatsUseCase(this),
                insertCatsUseCase = InsertCatsUseCase(this)
            ),
            pagingSourceFactory = { catsLocalDatasource.pagingSource() }
        ).flow
            .map { list ->
                list.map { it.toDomain() }
            }
    }
}