package com.r3d1r4ph.catsinfo.feature.cats.list.domain

import com.r3d1r4ph.catsinfo.feature.cats.domain.CatsRepository

class ClearCatsUseCase(private val catsRepository: CatsRepository) {
    suspend operator fun invoke() {
        catsRepository.clearAll()
    }
}