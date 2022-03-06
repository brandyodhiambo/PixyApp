package com.odhiambodevelopers.pixyapp.data.network.api

import com.google.gson.annotations.SerializedName
import com.odhiambodevelopers.pixyapp.data.local.PixyEntity
import com.odhiambodevelopers.pixyapp.model.PixyModel

data class ApiResponse(
    @SerializedName("hits")
    val hits: List<PixyEntity>
)
