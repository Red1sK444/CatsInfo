package com.r3d1r4ph.catsinfo.feature.cats.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.r3d1r4ph.catsinfo.feature.cats.list.domain.ClearCatsUseCase
import com.r3d1r4ph.catsinfo.feature.cats.list.domain.GetAllCatsUseCase
import com.r3d1r4ph.catsinfo.feature.cats.list.domain.InsertCatsUseCase
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatItem
import com.r3d1r4ph.catsinfo.utils.SingleLiveEvent

class ListViewModel(
    private val getAllCatsUseCase: GetAllCatsUseCase
) : ViewModel() {

    val openDetailsScreenEvent = SingleLiveEvent<String>()

    fun openDetailsScreen(catItem: CatItem) {
        openDetailsScreenEvent.setValue(catItem.id)
    }

    fun fetchCats(): LiveData<PagingData<CatItem>> = getAllCatsUseCase.invoke().asLiveData()
}