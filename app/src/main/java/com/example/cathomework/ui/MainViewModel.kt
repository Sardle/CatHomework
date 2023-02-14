package com.example.cathomework.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cathomework.domain.BreedData
import com.example.cathomework.domain.CatData
import com.example.cathomework.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _catLiveData = MutableLiveData<List<CatData>>()
    val catLiveData: LiveData<List<CatData>> get() = _catLiveData

    private val _breedLiveData = MutableLiveData<List<BreedData>>()
    val breedLiveData: LiveData<List<BreedData>> get() = _breedLiveData

    private val breedMap: MutableMap<String?, String?> = mutableMapOf()

    fun getCatImage(breed: String) {
        val idCat = getIdBread(breed)
        viewModelScope.launch {
            _catLiveData.value = repository.getCatImageUrl(idCat)
        }
    }

    fun getBreeds() {
        viewModelScope.launch {
            _breedLiveData.value = repository.getBreeds()
            for (i in _breedLiveData.value!!) {
                breedMap[i.breed] = i.idBreed
            }
        }
    }

    private fun getIdBread(breeds: String): String {
        return breedMap[breeds].toString()
    }
}