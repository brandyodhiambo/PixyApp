package com.odhiambodevelopers.pixyapp.data.network.api

import com.odhiambodevelopers.pixyapp.model.ApiResponse
import com.odhiambodevelopers.pixyapp.model.PixyModel
import com.odhiambodevelopers.pixyapp.utils.Constants.KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("?key=$KEY")
    suspend fun getPix(@Query("q") query: String?): ApiResponse
}