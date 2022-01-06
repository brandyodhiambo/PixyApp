package com.odhiambodevelopers.pixyapp.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odhiambodevelopers.pixyapp.data.model.PixyModel
import com.odhiambodevelopers.pixyapp.data.repository.PixyRepository
import com.odhiambodevelopers.pixyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PixyViewModel @Inject constructor(private val pixyRepository: PixyRepository) : ViewModel() {

    private val _pixResults = MutableLiveData<Resource<List<PixyModel>>>()
    val pixResults: LiveData<Resource<List<PixyModel>>> = _pixResults

    fun getAllPix(query:String)
    {
        viewModelScope.launch {
            _pixResults.value = Resource.Loading()
            _pixResults.value = pixyRepository.getALlPix(query)
        }
    }
}