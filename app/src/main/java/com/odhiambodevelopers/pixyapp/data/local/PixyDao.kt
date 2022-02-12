package com.odhiambodevelopers.pixyapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.odhiambodevelopers.pixyapp.data.network.api.ApiResponse
import com.odhiambodevelopers.pixyapp.model.PixyModel

@Dao
interface PixyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: ApiResponse)

    @Query("DELETE FROM pixyentity WHERE previewURL IN(:images)")
    suspend fun deleteImages(images: List<String>)

    @Query("SELECT * FROM pixyentity WHERE tags OR previewURL OR pageURL LIKE '%' || :query || '%'")
    suspend fun getImages(query: String?): List<PixyEntity>
}