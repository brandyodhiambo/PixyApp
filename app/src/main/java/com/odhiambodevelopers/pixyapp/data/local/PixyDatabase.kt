package com.odhiambodevelopers.pixyapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PixyEntity::class], version = 1)
abstract class PixyDatabase: RoomDatabase() {
        abstract val dao:PixyDao
}