package com.odhiambodevelopers.pixyapp.data.repository

import com.odhiambodevelopers.pixyapp.data.local.PixyDao
import com.odhiambodevelopers.pixyapp.data.local.PixyDatabase
import com.odhiambodevelopers.pixyapp.data.local.PixyEntity
import com.odhiambodevelopers.pixyapp.data.network.api.ApiService
import com.odhiambodevelopers.pixyapp.data.network.api.SafeApiCall
import com.odhiambodevelopers.pixyapp.model.PixyModel
import com.odhiambodevelopers.pixyapp.utils.Resource
import timber.log.Timber
import javax.inject.Inject

class PixyRepository@Inject constructor(private val apiService: ApiService,
                                        private val pixyDatabase: PixyDatabase): SafeApiCall() {
    suspend fun getALlPix(name:String?) = safeApiCall {
        apiService.getPix(name)
    }
    // Read the data in our cache
    suspend fun getImage(name:String): Resource<List<PixyModel>> {
        val images = pixyDatabase.dao.getImages(name).map { it.toImage() }
        return Resource.Loading(data = images)
    }


    suspend fun insertImages(pixy: List<PixyEntity>) = pixyDatabase.dao.insertImages(pixy)
    suspend fun deleteImage(image: List<String>) = pixyDatabase.dao.deleteImages(image)
}