package com.example.cathomework.data.network

import com.example.cathomework.data.models.BreedResponse
import retrofit2.Call
import retrofit2.http.GET

interface BreedService {

    @GET("breeds")
    fun getBreeds(): Call<List<BreedResponse>>
}