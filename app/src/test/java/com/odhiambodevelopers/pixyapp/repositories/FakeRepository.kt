package com.odhiambodevelopers.pixyapp.repositories

import com.odhiambodevelopers.pixyapp.data.local.PixyEntity
import com.odhiambodevelopers.pixyapp.data.repository.PixyRepo
import com.odhiambodevelopers.pixyapp.model.PixyModel
import com.odhiambodevelopers.pixyapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository :PixyRepo {
    private val pic = mutableListOf<PixyModel>()

    override suspend fun getImage(name: String): Flow<Resource<List<PixyEntity>>> {
        return flow {
            pic
        }

    }
}