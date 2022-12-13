package com.example.networkcompose.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cielonetwork.data.model.LoginRequest
import com.example.cielonetwork.data.model.LoginResponse
import com.example.cielonetwork.repository.ApiRepository
import com.example.cielonetwork.utils.Resource
import kotlinx.coroutines.launch

class LoginViewModel(
    private val apiRepository: ApiRepository
) : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var progressDialogVisibility by mutableStateOf(false)
    var isNetworkAvailable = false

    fun login(loginRequest: LoginRequest): LiveData<Resource<LoginResponse>> {
        val data = MutableLiveData<Resource<LoginResponse>>()
        viewModelScope.launch {
            data.value = apiRepository.login(loginRequest)
        }
        return data
    }
}