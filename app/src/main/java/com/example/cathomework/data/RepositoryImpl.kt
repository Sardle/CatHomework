package com.example.cathomework.data

import com.example.cathomework.data.mappers.BreedMapper
import com.example.cathomework.data.mappers.CatMapper
import com.example.cathomework.data.network.BreedRemoteData
import com.example.cathomework.data.network.CatRemoteData
import com.example.cathomework.domain.BreedData
import com.example.cathomework.domain.CatData
import com.example.cathomework.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val catMapper: CatMapper,
    private val breedMapper: BreedMapper,
    private val catRemoteData: CatRemoteData,
    private val breedRemoteData: BreedRemoteData
) : Repository {


    override suspend fun getBreeds(): List<BreedData> {
        return withContext(Dispatchers.IO) {
            val breeds = breedRemoteData.getBreed()
                .execute()
                .body()
                ?.map { it -> breedMapper(it) }
            breeds ?: throw Exception()
        }
    }

    override suspend fun getCatImageUrl(idCat: String): List<CatData> {
        return withContext(Dispatchers.IO) {
            val catImage = catRemoteData.getImage(idCat)
                .execute()
                .body()
                ?.map { it -> catMapper(it) }
            catImage ?: throw Exception()
        }
    }
}