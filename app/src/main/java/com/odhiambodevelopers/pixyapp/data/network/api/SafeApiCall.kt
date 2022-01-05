package com.odhiambodevelopers.pixyapp.data.network.api

import com.odhiambodevelopers.pixyapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

open class SafeApiCall {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.Failure(throwable.response()?.errorBody().toString(), null)
                    }
                    else -> {
                        Resource.Failure(throwable.localizedMessage, null)
                    }
                }
            }
        }
    }
}