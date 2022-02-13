package com.r3d1r4ph.catsinfo.feature.cats.list.domain

import androidx.paging.PagingData
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatItem
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatsRepository
import kotlinx.coroutines.flow.Flow

class GetAllCatsUseCase(private val catsRepository: CatsRepository) {
    operator fun invoke(): Flow<PagingData<CatItem>> = catsRepository.letCatsFlow()

}