package com.r3d1r4ph.catsinfo.feature.cats.list.domain

import com.r3d1r4ph.catsinfo.feature.cats.data.CatEntity
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatsRepository

class InsertCatsUseCase(private val catsRepository: CatsRepository) {
    suspend operator fun invoke(catEntities: List<CatEntity>) {
        catsRepository.insertAll(catEntities)
    }
}