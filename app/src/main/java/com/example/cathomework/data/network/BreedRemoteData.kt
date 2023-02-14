package com.example.cathomework.data.network

import javax.inject.Inject

class BreedRemoteData @Inject constructor(
    private val breedService: BreedService
) {

    fun getBreed() = breedService.getBreeds()
}