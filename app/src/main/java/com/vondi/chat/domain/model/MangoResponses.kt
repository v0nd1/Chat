package com.vondi.chat.domain.model

import com.google.gson.annotations.SerializedName

data class SendAuthCodeResponse(
    @SerializedName("is_success") val isSuccess: Boolean
)

data class CheckAuthCodeResponse(
    @SerializedName("refresh_token") val refreshToken: String?,
    @SerializedName("access_token") val accessToken: String?,
    @SerializedName("user_id") val userId: Int?,
    @SerializedName("is_user_exists") val isUserExists: Boolean
)

data class RefreshTokenResponse(
    @SerializedName("refresh_token") val refreshToken: String?,
    @SerializedName("access_token") val accessToken: String?,
    @SerializedName("user_id") val userId: Int?
)
