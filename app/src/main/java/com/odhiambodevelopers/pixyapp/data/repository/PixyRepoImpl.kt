package com.odhiambodevelopers.pixyapp.data.repository

import com.odhiambodevelopers.pixyapp.data.local.PixyDatabase
import com.odhiambodevelopers.pixyapp.data.local.PixyEntity
import com.odhiambodevelopers.pixyapp.data.network.api.ApiService
import com.odhiambodevelopers.pixyapp.data.network.api.SafeApiCall
import com.odhiambodevelopers.pixyapp.model.PixyModel
import com.odhiambodevelopers.pixyapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class PixyRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val pixyDatabase: PixyDatabase
) : PixyRepo,SafeApiCall() {

    // Read the data in our cache
    override suspend fun getImage(name: String): Flow<Resource<List<PixyEntity>>> {
        return flow {
            emit(Resource.Loading())

            // Read the data in our cache
            val images = pixyDatabase.dao.getImages(name)
            emit(Resource.Loading(data = images))

            try {
                // Get our words anc replace them in the database
                val data = apiService.getPix(name)
                pixyDatabase.dao.deleteImages(data.hits.map { it.previewURL })
                pixyDatabase.dao.insertImages(data.hits)

            } catch (e: HttpException) {
                emit(
                    Resource.Failure(
                        message = "Oops, something went wrong!",
                        data = images
                    )
                )

            } catch (e: IOException) {
                emit(
                    Resource.Failure(
                        message = "Couldn't reach server, check your internet connection!",
                        data = images
                    )
                )
            }

            // Emit our data to the UI
            val newImages = pixyDatabase.dao.getImages(name)
            emit(Resource.Success(newImages))
        }
    }

}