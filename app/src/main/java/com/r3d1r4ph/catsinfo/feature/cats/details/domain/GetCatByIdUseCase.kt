package com.r3d1r4ph.catsinfo.feature.cats.details.domain

import com.r3d1r4ph.catsinfo.feature.cats.domain.CatsRepository

class GetCatByIdUseCase(private val catsRepository: CatsRepository) {
    suspend operator fun invoke(catId: String) = catsRepository.getCatById(catId).toDomain()

}