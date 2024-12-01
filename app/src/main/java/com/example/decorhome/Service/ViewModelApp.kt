package com.example.decorhome.Service

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModelApp : ViewModel(){
    private val _register = mutableStateOf<RegisterReponse?>(null)
    val register: State<RegisterReponse?> = _register

    fun registerViewModel(registerRequest: RegisterRequest){
        viewModelScope.launch {
            try {
                val response =  RetrofitInstance.api.register(registerRequest)
                Log.d("response", response.toString())
                _register.value = RetrofitInstance.api.register(registerRequest)

            }catch (e: Exception){
                Log.d("=======", e.toString())
            }
        }
    }

    private val _login = mutableStateOf<LoginReponse?>(null)
    val login: State<LoginReponse?> = _login

    fun loginViewModel(loginRequest: LoginRequest){
        viewModelScope.launch {
            try {
                val response =  RetrofitInstance.api.login(loginRequest)
                Log.d("response", response.toString())
                _login.value = RetrofitInstance.api.login(loginRequest)

            }catch (e: Exception){
                Log.d("=======", e.toString())
            }
        }
    }

    private val _listcate = mutableStateOf<CategoryResponse?>(null)
    val listcate: State<CategoryResponse?> = _listcate

    fun getcateViewModel(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCategory()
                response?.let {
                    _listcate.value = CategoryResponse(
                        status = true,
                        type = response.type
                    )
                    Log.d("Categories" , response.type.toString())
                }
            }catch (e: Exception){


                Log.d("=======", e.toString())
            }
        }
    }
    private val _listproduct = mutableStateOf<GetProductResonse?>(null)
    val listproduct: State<GetProductResonse?> = _listproduct

    fun getproductViewModel(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getproduct()
                response?.let {
                    _listproduct.value = GetProductResonse(
                        status = true,
                        product = response.product
                    )
                    Log.d("product" , response.product.toString())
                }
            }catch (e: Exception){


                Log.d("=======", e.toString())
            }
        }
    }


    private val _detailproduct = mutableStateOf<GetProductDetailResponse?>(null)
    val detailproduct: State<GetProductDetailResponse?> = _detailproduct

    fun getproductById(_id : String){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getproductById(_id = _id)
                response?.let {
                    _detailproduct.value = GetProductDetailResponse(
                        status = true,
                        message = response.message,
                        product = response.product,
                    )
                    Log.d("Get Product By Id:" , response.product.toString())
                }
            }catch (e: Exception){


                Log.d("Get Product By Id:", e.toString())
            }
        }
    }

}
