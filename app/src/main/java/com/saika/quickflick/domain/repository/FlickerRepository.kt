package com.saika.quickflick.domain.repository

import com.saika.quickflick.data.model.FlickerImage
import com.saika.quickflick.domain.util.Resource

interface FlickerRepository {

    suspend fun  searchImages(query: String): Resource<List<FlickerImage>>
}