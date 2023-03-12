package com.example.cathomework.di

import com.example.cathomework.data.network.BreedRemoteData
import com.example.cathomework.data.network.BreedService
import com.example.cathomework.data.network.CatRemoteData
import com.example.cathomework.data.network.CatService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CatsModule {

    @Provides
    @Singleton
    fun providesBaseUrl(): String = "https://api.thecatapi.com/v1/"

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL: String): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCatService(retrofit: Retrofit): CatService = retrofit.create(CatService::class.java)

    @Provides
    @Singleton
    fun provideCatRemoteData(catService: CatService): CatRemoteData = CatRemoteData(catService)

    @Provides
    @Singleton
    fun provideBreedService(retrofit: Retrofit): BreedService =
        retrofit.create(BreedService::class.java)

    @Provides
    @Singleton
    fun provideBreedRemoteData(breedService: BreedService): BreedRemoteData =
        BreedRemoteData(breedService)
}