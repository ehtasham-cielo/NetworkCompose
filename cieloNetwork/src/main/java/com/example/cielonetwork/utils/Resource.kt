package com.example.cielonetwork.utils

sealed class Resource<T>(val data: T?,val message: String?){
    class Success<T>(data: T?,message: String?) : Resource<T>(data,message)
    class Error<T>(message: String?) : Resource<T>(null,message)

    // enum, login call with same method, onloadmore and on pull to refresh
    // message,
}
