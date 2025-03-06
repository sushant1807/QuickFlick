package com.saika.quickflick.data.repository

import com.saika.quickflick.data.model.FlickerImage
import com.saika.quickflick.domain.util.Resource
import com.saika.quickflick.data.remote.FlickerApiService
import com.saika.quickflick.domain.repository.FlickerRepository

class FlickerRepositoryImpl(private val apiService: FlickerApiService) : FlickerRepository {
    override suspend fun searchImages(query: String): Resource<List<FlickerImage>> {
        return try {
            val response = apiService.searchImages(tags = query).items
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("Failed to load images: ${e.localizedMessage}")
        }
    }
}