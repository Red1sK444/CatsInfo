package com.r3d1r4ph.catsinfo.feature.cats.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.r3d1r4ph.catsinfo.database.AppDatabase
import com.r3d1r4ph.catsinfo.database.CatEntity
import com.r3d1r4ph.catsinfo.feature.cats.domain.ClearCatsUseCase
import com.r3d1r4ph.catsinfo.feature.cats.domain.InsertCatsUseCase
import com.r3d1r4ph.catsinfo.serverapi.cats.CatsService
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class CatsRemoteMediator(
    private val database: AppDatabase,
    private val catsService: CatsService,
    private val clearCatsUseCase: ClearCatsUseCase,
    private val insertCatsUseCase: InsertCatsUseCase
) : RemoteMediator<Int, CatEntity>() {

    companion object {
        const val PAGE_SIZE = 5
        private const val DEFAULT_PAGE_INDEX = 0
    }

    private var currentPage = DEFAULT_PAGE_INDEX

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CatEntity>
    ): MediatorResult {
        return try {
            when (loadType) {
                LoadType.REFRESH -> currentPage = DEFAULT_PAGE_INDEX
                LoadType.PREPEND -> {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                LoadType.APPEND -> currentPage += 1
            }

            val response = catsService.cats(
                limit = state.config.pageSize,
                page = currentPage
            )

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    clearCatsUseCase.invoke()
                }

                insertCatsUseCase.invoke(response.body()?.map { it.toEntity() } ?: listOf())
            }

            MediatorResult.Success(endOfPaginationReached = response.body()?.isEmpty() == true)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }
}