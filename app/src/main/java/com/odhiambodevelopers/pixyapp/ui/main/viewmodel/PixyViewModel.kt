package com.odhiambodevelopers.pixyapp.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odhiambodevelopers.pixyapp.data.repository.PixyRepository
import com.odhiambodevelopers.pixyapp.data.network.api.ApiResponse
import com.odhiambodevelopers.pixyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PixyViewModel @Inject constructor(private val pixyRepository: PixyRepository) : ViewModel() {

    private val _pixResults = MutableLiveData<Resource<ApiResponse>>()
    val pixResults: LiveData<Resource<ApiResponse>> = _pixResults

    private val _searchWord = MutableLiveData("")
    val searchWord: LiveData<String?> = _searchWord

    private val _store = MutableLiveData("")
    val store: LiveData<String?> = _store

    init {
        getAllPix("dogs")
    }

    fun getAllPix(query: String) {
        _searchWord.value = query
        viewModelScope.launch {
            _pixResults.value = Resource.Loading()
            _pixResults.value = pixyRepository.getALlPix(query)
            Timber.d("${pixyRepository.getALlPix(query)}")
        }
        Timber.d("Viewmodel")
    }

    fun storeImages(query: String){
        _store.value = query
        viewModelScope.launch {
            pixyRepository.getImage(query)
            pixyRepository.insertImages(query)
            Timber.d("${pixyRepository.insertImages(query)}")
        }
    }
}