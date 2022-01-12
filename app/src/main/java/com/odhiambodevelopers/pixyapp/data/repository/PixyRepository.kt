package com.odhiambodevelopers.pixyapp.data.repository

import com.odhiambodevelopers.pixyapp.data.network.api.ApiService
import com.odhiambodevelopers.pixyapp.data.network.api.SafeApiCall
import timber.log.Timber
import javax.inject.Inject

class PixyRepository@Inject constructor(private val apiService: ApiService): SafeApiCall() {
    suspend fun getALlPix(name:String?) = safeApiCall {
        apiService.getPix(name)
    }
}