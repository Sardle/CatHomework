package com.example.cathomework.data.mappers

import com.example.cathomework.data.models.CatResponse
import com.example.cathomework.domain.CatData
import javax.inject.Inject

class CatMapper @Inject constructor() {

    operator fun invoke(response: CatResponse): CatData = with(response) {
        CatData(
            catImageUrl = catImageUrl.orEmpty()
        )
    }
}