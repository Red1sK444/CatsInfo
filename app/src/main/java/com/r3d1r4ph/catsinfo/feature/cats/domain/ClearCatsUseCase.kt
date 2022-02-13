package com.r3d1r4ph.catsinfo.feature.cats.domain

class ClearCatsUseCase(private val catsRepository: CatsRepository) {
    suspend operator fun invoke() {
        catsRepository.clearAll()
    }
}