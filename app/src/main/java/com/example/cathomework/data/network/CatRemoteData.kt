package com.example.cathomework.data.network

import javax.inject.Inject

class CatRemoteData @Inject constructor(
    private val catService: CatService
) {

    fun getImage(idCat: String) = catService.getImageCat(idCat, 5)
}