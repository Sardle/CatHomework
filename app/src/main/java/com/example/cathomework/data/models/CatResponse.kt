package com.example.cathomework.data.models

import com.google.gson.annotations.SerializedName

data class CatResponse(
    @SerializedName("url") val catImageUrl: String? = null
)