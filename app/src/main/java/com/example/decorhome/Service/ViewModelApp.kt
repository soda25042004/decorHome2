package com.example.decorhome.Service

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

class ViewModelApp : ViewModel(){
    private val _register = mutableStateOf<RegisterReponse?>(null)
    val register: State<RegisterReponse?> = _register

    fun registerViewModel(registerRequest: RegisterRequest){
        viewModelScope.launch {
            try {
                _register.value = RetrofitInstance.api.register(registerRequest)
            }catch (e: Exception){
                Log.d("=======", e.toString())
            }
        }
    }
}