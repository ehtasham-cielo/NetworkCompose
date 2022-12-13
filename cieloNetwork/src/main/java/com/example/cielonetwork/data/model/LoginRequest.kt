package com.example.cielonetwork.data.model


import com.google.gson.annotations.SerializedName

data class LoginRequest(
   val user: User
){
    data class User(
        @SerializedName("userId")
        val userId: String,
        @SerializedName("password")
        val password: String,
        @SerializedName("mobileDeviceId")
        val mobileDeviceId: String,
        @SerializedName("deviceTokenId")
        val deviceTokenId: String,
        @SerializedName("appType")
        val appType: String,
        @SerializedName("appVersion")
        val appVersion: String,
        @SerializedName("timeZone")
        val timeZone: String,
        @SerializedName("mobileDeviceName")
        val mobileDeviceName: String,
        @SerializedName("deviceType")
        val deviceType: String,
        @SerializedName("ipAddress")
        val ipAddress: String
    )
}