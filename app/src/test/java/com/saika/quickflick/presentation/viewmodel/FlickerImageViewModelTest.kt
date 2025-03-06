package com.saika.quickflick.presentation.viewmodel

import com.saika.quickflick.data.repository.FakeRepository
import com.saika.quickflick.domain.usecase.SearchImagesUseCase
import com.saika.quickflick.domain.util.Resource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class FlickerImageViewModelTest {

    private lateinit var viewModel: FlickerImageViewModel
    private lateinit var searchImagesUseCase: SearchImagesUseCase

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        searchImagesUseCase = SearchImagesUseCase(FakeRepository())
        viewModel = FlickerImageViewModel(searchImagesUseCase)
    }

    @Test
    fun `searchImages updates uiState with success data`() = runTest {
        viewModel.searchImages("cars")

        testDispatcher.scheduler.advanceUntilIdle()

        assert(viewModel.uiState.value is Resource.Success)
        assertEquals(1, (viewModel.uiState.value as Resource.Success).data.size)
    }
}