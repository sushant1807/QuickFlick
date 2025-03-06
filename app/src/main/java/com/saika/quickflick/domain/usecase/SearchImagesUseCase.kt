package com.saika.quickflick.domain.usecase

import com.saika.quickflick.data.model.FlickerImage
import com.saika.quickflick.domain.util.Resource
import com.saika.quickflick.domain.repository.FlickerRepository


class SearchImagesUseCase(private val repository: FlickerRepository) {

    suspend operator fun invoke(query: String): Resource<List<FlickerImage>> {
        return repository.searchImages(query)
    }
}