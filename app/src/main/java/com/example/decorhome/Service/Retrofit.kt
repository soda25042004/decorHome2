package com.example.decorhome.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Path


data class RegisterRequest(val name: String, val email: String, val password: String)
data class RegisterReponse(val status: Boolean, val message: String)
data class LoginRequest(val email: String, val password: String)
data class LoginReponse(val status: Boolean, val message: String)
data class Category(
    val _id: String,
    val name: String
)
data class CategoryResponse(    val status: Boolean = false,
                                val type: List<Category> = emptyList())


data class Product(
    val _id: String,
    val name: String,
    val ratings: Double,
    val price: Int,
    val image: String,
    val size: String,
    val origin: String,
    val type: Category
)

data class GetProductResonse(
    val status: Boolean = false,
    val product: List<Product> =  emptyList()
)

data class GetProductDetailResponse(
    val status: Boolean = false,
    val message: String,
    val product: Product,
)

interface ApiService {
    @POST("user/register")
    suspend fun register(@Body registerRequest : RegisterRequest): RegisterReponse?

    @POST("user/dangnhap")
    suspend fun login(@Body loginRequest: LoginRequest): LoginReponse?

    @GET("type/listcate")
    suspend fun getCategory(): CategoryResponse?

    @GET("product/danhsach")
    suspend fun getproduct(): GetProductResonse?

    @GET("product/sanpham/{id}")
    suspend fun getproductById(@Path("id") _id: String?): GetProductDetailResponse?

}

object RetrofitInstance {
    private const val BASE_URL = "https://apidata-kj0v.onrender.com/"
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}