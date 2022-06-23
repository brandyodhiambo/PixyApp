package com.odhiambodevelopers.pixyapp.ui.main.viewmodel

import androidx.lifecycle.*
import com.odhiambodevelopers.pixyapp.data.local.PixyEntity
import com.odhiambodevelopers.pixyapp.data.repository.PixyRepoImpl
import com.odhiambodevelopers.pixyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PixyViewModel @Inject constructor(private val pixyRepository: PixyRepoImpl, savedStateHandle:SavedStateHandle) : ViewModel() {

    private val _searchQuery = MutableLiveData("dog")
    val searchQuery : LiveData<String> = _searchQuery

    private val _pictureDetails = MutableLiveData(savedStateHandle.get<PixyEntity>("imageDetails"))
    val pictureDetails: LiveData<PixyEntity?> = _pictureDetails

    suspend fun getImages(query: String) : Flow<Resource<List<PixyEntity>>>{
        _searchQuery.value = query
        return pixyRepository.getImage(query)
    }

   /* operator fun invoke(name: String): Flow<Resource<List<PixyModel>>>{
        return pixyRepository.getImage(name)
    }*/
}