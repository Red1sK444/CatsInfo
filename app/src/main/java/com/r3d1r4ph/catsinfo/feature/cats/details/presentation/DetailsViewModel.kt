package com.r3d1r4ph.catsinfo.feature.cats.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r3d1r4ph.catsinfo.feature.cats.details.domain.GetCatByIdUseCase
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getCatByIdUseCase: GetCatByIdUseCase,
    private val catId: String
) : ViewModel() {

    private val _catImage = MutableLiveData<String>()
    val catImage: LiveData<String>
        get() = _catImage

    fun getCatById() {
        viewModelScope.launch {
            _catImage.value = getCatByIdUseCase.invoke(catId).url
        }
    }
}