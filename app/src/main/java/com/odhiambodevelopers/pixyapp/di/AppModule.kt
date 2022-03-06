package com.odhiambodevelopers.pixyapp.di

import android.app.Application
import androidx.room.Room
import com.odhiambodevelopers.pixyapp.data.local.PixyDatabase
import com.odhiambodevelopers.pixyapp.data.network.api.ApiService
import com.odhiambodevelopers.pixyapp.data.repository.PixyRepository
import com.odhiambodevelopers.pixyapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService():ApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePixyRepository(apiService: ApiService,pixyDatabase:PixyDatabase):PixyRepository{
        return PixyRepository(apiService, pixyDatabase)
    }

    /*@Provides
    @Singleton
    fun provideCarListAPI(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)*/

    @Provides
    @Singleton
    fun provideDatabase(app: Application): PixyDatabase =
        Room.databaseBuilder(app, PixyDatabase::class.java, "picture")
            .build()

}