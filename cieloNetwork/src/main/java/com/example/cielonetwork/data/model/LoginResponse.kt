package com.example.cielonetwork.data.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val `data`: Data
){
    data class Data(
        @SerializedName("user")
        val user: User
    ){
        data class User(
            @SerializedName("curSymOrientation")
            val curSymOrientation: Double,
            @SerializedName("devCurrencyIndex")
            val devCurrencyIndex: Double,
            @SerializedName("currencySymbol")
            val currencySymbol: String,
            @SerializedName("isEmailVerified")
            val isEmailVerified: Boolean,
            @SerializedName("userCoverUrl")
            val userCoverUrl: String,
            @SerializedName("userImageUrl")
            val userImageUrl: String,
            @SerializedName("signedCoverUrl")
            val signedCoverUrl: String,
            @SerializedName("signedImageUrl")
            val signedImageUrl: String,
            @SerializedName("unitPrice")
            val unitPrice: Double,
            @SerializedName("contactNo")
            val contactNo: String,
            @SerializedName("isDefault")
            val isDefault: Int,
            @SerializedName("isSocialMedia")
            val isSocialMedia: Int,
            @SerializedName("socialAccountType")
            val socialAccountType: Int,
            @SerializedName("createdAt")
            val createdAt: String,
            @SerializedName("emailId")
            val emailId: String,
            @SerializedName("userId")
            val userId: String,
            @SerializedName("isFilterAlertEnabled")
            val isFilterAlertEnabled: Int,
            @SerializedName("isFilterEmailEnabled")
            val isFilterEmailEnabled: Int,
            @SerializedName("nestAccessToken")
            val nestAccessToken: String,
            @SerializedName("userDeviceLimit")
            val userDeviceLimit: Int,
            @SerializedName("userGroupLimit")
            val userGroupLimit: Int,
            @SerializedName("notificationBlocked")
            val notificationBlocked: Int,
            @SerializedName("isAppActionsAlertEnabled")
            val isAppActionsAlertEnabled: Int,
            @SerializedName("accessToken")
            val accessToken: String,
            @SerializedName("expiresIn")
            val expiresIn: Int,
            @SerializedName("refreshToken")
            val refreshToken: String,
            @SerializedName("manufactureDbVersion")
            val manufactureDbVersion: String,
            @SerializedName("userName")
            val userName: String,
            @SerializedName("firstName")
            val firstName: String,
            @SerializedName("lastName")
            val lastName: String,
            @SerializedName("userLevelIndex")
            val userLevelIndex: Int,
            @SerializedName("parentUser")
            val parentUser: String,
            @SerializedName("isBleEnabledAvailable")
            val isBleEnabledAvailable: Int,
            @SerializedName("isIosRatingRequired")
            val isIosRatingRequired: Int,
            @SerializedName("isAndroidRatingRequired")
            val isAndroidRatingRequired: Int,
            @SerializedName("version")
            val version: Int,
            @SerializedName("androidVersionCode")
            val androidVersionCode: Double,
            @SerializedName("androidLatestVersionCode")
            val androidLatestVersionCode: Double,
            @SerializedName("androidExpiryTime")
            val androidExpiryTime: Long,
            @SerializedName("appVersion")
            val appVersion: String,
            @SerializedName("appLatestVersion")
            val appLatestVersion: String,
            @SerializedName("appExpiryTime")
            val appExpiryTime: Long
        )
    }
}