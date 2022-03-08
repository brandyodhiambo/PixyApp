package com.odhiambodevelopers.pixyapp.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PixyModel(
    val collections: Int?,
    val comments: Int?,
    val downloads: Int?,
    val id: Int?,
    val imageHeight: Int?,
    val imageSize: Int?,
    val imageWidth: Int?,
    val largeImageURL: String?,
    val likes: Int?,
    val pageURL: String?,
    val previewHeight: Int?,
    val previewURL: String?,
    val previewWidth: Int?,
    val tags: String?,
    val type: String?,
    val user: String?,
    val userId: Int?,
    val userImageURL: String?,
    val views: Int?,
    val webformatHeight: Int?,
    val webformatURL: String?,
    val webformatWidth: Int?
) : Parcelable