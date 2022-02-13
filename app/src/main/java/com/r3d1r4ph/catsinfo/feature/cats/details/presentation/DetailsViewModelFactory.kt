package com.r3d1r4ph.catsinfo.feature.cats.details.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.r3d1r4ph.catsinfo.app.BreakingBadApplication
import com.r3d1r4ph.catsinfo.feature.cats.details.domain.GetCatByIdUseCase

class DetailsViewModelFactory(private val application: Application, private val catId: String) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val repository = (application as BreakingBadApplication).catsRepository

        return DetailsViewModel(
            GetCatByIdUseCase(repository),
            catId
        ) as T
    }
}