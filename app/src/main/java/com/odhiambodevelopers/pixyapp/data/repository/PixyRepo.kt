package com.odhiambodevelopers.pixyapp.data.repository

import com.odhiambodevelopers.pixyapp.data.local.PixyEntity
import com.odhiambodevelopers.pixyapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PixyRepo {
    suspend fun getImage(name:String): Flow<Resource<List<PixyEntity>>>
}