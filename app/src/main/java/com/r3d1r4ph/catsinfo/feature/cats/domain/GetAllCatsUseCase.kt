package com.r3d1r4ph.catsinfo.feature.cats.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class GetAllCatsUseCase(private val catsRepository: CatsRepository) {
    operator fun invoke(): Flow<PagingData<CatItem>> = catsRepository.letCatsFlow()

}