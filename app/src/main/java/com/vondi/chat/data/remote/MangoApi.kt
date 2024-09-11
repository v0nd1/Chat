package com.vondi.chat.data.remote

import com.vondi.chat.domain.model.CheckAuthCodeRequest
import com.vondi.chat.domain.model.CheckAuthCodeResponse
import com.vondi.chat.domain.model.RefreshTokenResponse
import com.vondi.chat.domain.model.RegisterRequest
import com.vondi.chat.domain.model.SendAuthCodeRequest
import com.vondi.chat.domain.model.SendAuthCodeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface MangoApi {
    @POST("/api/v1/users/send-auth-code/")
    suspend fun sendAuthCode(@Body requestBody: SendAuthCodeRequest): Response<SendAuthCodeResponse>

    @POST("/api/v1/users/check-auth-code/")
    suspend fun checkAuthCode(@Body requestBody: CheckAuthCodeRequest): Response<CheckAuthCodeResponse>

    @POST("/api/v1/users/refresh-token/")
    suspend fun refreshToken(@Header("Authorization") refreshToken: String): Response<RefreshTokenResponse>

    @POST("/api/v1/users/register/")
    suspend fun register(@Body requestBody: RegisterRequest): Response<RefreshTokenResponse>

}