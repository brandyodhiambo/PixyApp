package com.odhiambodevelopers.pixyapp.data.remote

import android.content.Context
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import com.odhiambodevelopers.pixyapp.data.network.api.ApiService
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

class FakeApi {

    private var context: Context? = null
    private var mockWebServer = MockWebServer()
    private lateinit var apiService: ApiService

    @Before
    fun setup(){
        mockWebServer.start()

        val loggingIntercepter = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        context = InstrumentationRegistry.getInstrumentation().targetContext

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingIntercepter)
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()

        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)

        val jsonStream:InputStream = context!!.resources.assets.open("response.json")
        val jsonByte:ByteArray = jsonStream.readBytes()

        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(String(jsonByte))
        mockWebServer.enqueue(response)
    }

    @After
    fun teardown(){
        mockWebServer.shutdown()
    }

    @Test
    fun test_response(){
        return runBlocking {
            val data = apiService.getPix("dog").hits
            ViewMatchers.assertThat(data[0].tags, CoreMatchers.equalTo("book, dog, fairy tales"))        }
    }

}