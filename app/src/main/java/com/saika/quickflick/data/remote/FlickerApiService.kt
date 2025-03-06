package com.saika.quickflick.data.remote

import com.saika.quickflick.data.model.FlickerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickerApiService {

    @GET("services/feeds/photos_public.gne")
    suspend fun searchImages(
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: Int = 1,
        @Query("tags") tags: String,
    ): FlickerResponse
}