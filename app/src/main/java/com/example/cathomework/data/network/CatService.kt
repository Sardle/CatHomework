package com.example.cathomework.data.network

import com.example.cathomework.data.models.CatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {

    @GET("images/search")
    fun getImageCat(
        @Query("breed_ids") idCat: String,
        @Query("limit") limit: Int
    ): Call<List<CatResponse>>
}