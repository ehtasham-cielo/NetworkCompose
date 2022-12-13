package com.example.cielonetwork.repository


import com.example.cielonetwork.data.model.LoginRequest
import com.example.cielonetwork.data.model.LoginResponse
import com.example.cielonetwork.network.ApiInterface
import com.example.cielonetwork.utils.Resource
import org.json.JSONObject

class ApiRepository(
    private val apiInterface: ApiInterface
) {

    suspend fun login(loginRequest: LoginRequest): Resource<LoginResponse> {
        return try {
            val response = apiInterface.login(loginRequest)
            if(response.isSuccessful){
                Resource.Success(response.body()!!,"Login Successfully")
            }else{
                val errorResponse = response.errorBody()!!.charStream().readText()
                val errorJsonObject = JSONObject(errorResponse)
                val message = errorJsonObject.getJSONObject("error").getString("message")
                Resource.Error(message)
            }
        }catch (e: Exception){
            Resource.Error("Error Occur: ${e.localizedMessage}")
        }
    }

}