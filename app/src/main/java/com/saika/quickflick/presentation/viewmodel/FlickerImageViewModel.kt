package com.saika.quickflick.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saika.quickflick.data.model.FlickerImage
import com.saika.quickflick.domain.util.Resource
import com.saika.quickflick.domain.usecase.SearchImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlickerImageViewModel @Inject constructor(
    private val searchImagesUseCase: SearchImagesUseCase
): ViewModel() {

    val uiState = MutableStateFlow<Resource<List<FlickerImage>>>(Resource.Success(emptyList()))
    //val state: StateFlow<Resource<List<FlickerImage>>> = uiState.asStateFlow()

    fun searchImages(query: String){
        viewModelScope.launch {
            uiState.value = Resource.Loading

            val result = searchImagesUseCase(query)

            uiState.value = result
        }
    }
}