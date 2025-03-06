package com.saika.quickflick.di

import com.saika.quickflick.BuildConfig
import com.saika.quickflick.data.remote.FlickerApiService
import com.saika.quickflick.data.repository.FlickerRepositoryImpl
import com.saika.quickflick.domain.repository.FlickerRepository
import com.saika.quickflick.domain.usecase.SearchImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideFlickerApiService(): FlickerApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FlickerApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideFlickerRepository(apiService: FlickerApiService): FlickerRepository {
        return FlickerRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideFlickerSearchUseCase(repository: FlickerRepository): SearchImagesUseCase {
        return SearchImagesUseCase(repository)
    }
}