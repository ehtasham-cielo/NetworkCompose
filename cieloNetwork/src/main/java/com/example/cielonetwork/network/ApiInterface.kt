package com.example.cielonetwork.network

import com.example.cielonetwork.data.model.LoginRequest
import com.example.cielonetwork.data.model.LoginResponse
import com.example.cielonetwork.utils.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface ApiInterface {

    @POST("user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ) : Response<LoginResponse>

    companion object{

        val Instance by lazy { getInstance(getRetrofit()) }

        private fun getRetrofit(): Retrofit{
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val interceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

            val client: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.MINUTES)
                .writeTimeout(50, TimeUnit.MINUTES)
                .readTimeout(50, TimeUnit.MINUTES)
                .followRedirects(false)
                .addInterceptor(interceptor)
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("x-api-key", Constants.X_API_KEY)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Accept", "application/json")
                        .build()
                    chain.proceed(request)
                }
                .followSslRedirects(false)
                .retryOnConnectionFailure(true)
                .cache(null)
                .build()

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }

        private fun getInstance(retrofit: Retrofit): ApiInterface {
            return retrofit.create(ApiInterface::class.java)
        }

    }
}