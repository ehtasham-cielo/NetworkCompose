package com.example.networkcompose.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cielonetwork.repository.ApiRepository

class LoginViewModelFactory(
    private val apiRepository: com.example.cielonetwork.repository.ApiRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(apiRepository) as T
    }
}