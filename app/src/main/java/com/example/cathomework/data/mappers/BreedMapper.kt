package com.example.cathomework.data.mappers

import com.example.cathomework.data.models.BreedResponse
import com.example.cathomework.domain.BreedData
import javax.inject.Inject

class BreedMapper @Inject constructor() {

    operator fun invoke(response: BreedResponse): BreedData = with(response) {
        BreedData(
            idBreed = idBreed.orEmpty(),
            breed = breed.orEmpty()
        )
    }
}