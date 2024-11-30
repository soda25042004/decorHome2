package com.example.decorhome.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


data class RegisterRequest(val name: String, val email: String, val password: String)
data class RegisterReponse(val status: Boolean, val message: String)

interface ApiService {
    @POST("user/register")
    suspend fun register(@Body registerRequest: RegisterRequest): RegisterReponse?
}

object RetrofitInstance {
    private const val BASE_URL = "https://apicode-31kw.onrender.com/"
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}