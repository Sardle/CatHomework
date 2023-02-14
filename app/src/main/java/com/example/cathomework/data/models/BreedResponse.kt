package com.example.cathomework.data.models

import com.google.gson.annotations.SerializedName

data class BreedResponse(
    @SerializedName("id") val idBreed: String? = null,
    @SerializedName("name") val breed: String? = null
)
