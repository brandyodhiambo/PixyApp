package com.odhiambodevelopers.pixyapp.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("hits")
    val hits: List<PixyModel>
)
