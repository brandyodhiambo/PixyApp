package com.odhiambodevelopers.pixyapp.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odhiambodevelopers.pixyapp.data.local.PixyEntity
import com.odhiambodevelopers.pixyapp.data.repository.PixyRepository
import com.odhiambodevelopers.pixyapp.data.network.api.ApiResponse
import com.odhiambodevelopers.pixyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PixyViewModel @Inject constructor(private val pixyRepository: PixyRepository) : ViewModel() {

    private val _searchQuery = MutableLiveData("dog")
    val searchQuery : LiveData<String> = _searchQuery

    suspend fun getImages(query: String) : Flow<Resource<List<PixyEntity>>>{
        _searchQuery.value = query
        return pixyRepository.getImage(query)
    }

    /*
    *     operator fun invoke(name: String): Flow<Resource<List<Image>>>{
        return repository.getImages(name)
    }*/
}