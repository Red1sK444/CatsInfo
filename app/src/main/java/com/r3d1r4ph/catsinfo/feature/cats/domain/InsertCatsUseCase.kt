package com.r3d1r4ph.catsinfo.feature.cats.domain

import com.r3d1r4ph.catsinfo.database.CatEntity

class InsertCatsUseCase(private val catsRepository: CatsRepository) {
    suspend operator fun invoke(catEntities: List<CatEntity>) {
        catsRepository.insertAll(catEntities)
    }
}