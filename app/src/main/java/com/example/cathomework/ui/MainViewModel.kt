package com.example.cathomework.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cathomework.domain.BreedData
import com.example.cathomework.domain.CatData
import com.example.cathomework.domain.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _catLiveData = MutableLiveData<List<CatData>>()
    val catLiveData: LiveData<List<CatData>> = _catLiveData

    private val _breedLiveData = MutableLiveData<List<BreedData>>()
    val breedLiveData: LiveData<List<BreedData>> = _breedLiveData

    private val breedMap = mutableMapOf<String, String>()

    fun getCatImage(breed: String) {
        viewModelScope.launch {
            val idCat = getIdBread(breed)
            val catImageUrl = repository.getCatImageUrl(idCat)
            _catLiveData.value = catImageUrl
        }
    }

    fun getBreeds() {
        viewModelScope.launch {
            val breeds = repository.getBreeds()
            _breedLiveData.value = breeds
            breedMap.putAll(breeds.associateBy { it.breed }.mapValues { it.value.idBreed })
        }
    }

    private fun getIdBread(breed: String): String {
        return breedMap[breed].orEmpty()
    }
}