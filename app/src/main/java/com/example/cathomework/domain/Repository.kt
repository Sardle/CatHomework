package com.example.cathomework.domain

interface Repository {

    suspend fun getBreeds(): List<BreedData>

    suspend fun getCatImageUrl(idCat: String): List<CatData>
}