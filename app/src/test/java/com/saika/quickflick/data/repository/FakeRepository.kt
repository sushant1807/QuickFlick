package com.saika.quickflick.data.repository

import com.saika.quickflick.data.model.FlickerImage
import com.saika.quickflick.data.model.FlickerMedia
import com.saika.quickflick.domain.repository.FlickerRepository
import com.saika.quickflick.domain.util.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class FakeRepository : FlickerRepository {
    override suspend fun searchImages(query: String): Resource<List<FlickerImage>> {
        return Resource.Success(
            listOf(
                FlickerImage(
                    title = "Testing Image Title",
                    media = FlickerMedia("test_url"),
                    description = "Test Description",
                    published = "2024-03-06",
                    author = "Test Author"
                )
            )
        )
    }
}
