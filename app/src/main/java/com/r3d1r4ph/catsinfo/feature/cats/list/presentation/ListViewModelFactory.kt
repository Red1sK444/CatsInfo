package com.r3d1r4ph.catsinfo.feature.cats.list.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.r3d1r4ph.catsinfo.app.BreakingBadApplication
import com.r3d1r4ph.catsinfo.feature.cats.list.domain.ClearCatsUseCase
import com.r3d1r4ph.catsinfo.feature.cats.list.domain.GetAllCatsUseCase
import com.r3d1r4ph.catsinfo.feature.cats.list.domain.InsertCatsUseCase

class ListViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val repository = (application as BreakingBadApplication).catsRepository

        return ListViewModel(
            GetAllCatsUseCase(repository)
        ) as T
    }
}