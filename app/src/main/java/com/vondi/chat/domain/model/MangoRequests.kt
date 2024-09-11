package com.vondi.chat.domain.model

data class SendAuthCodeRequest(
    val phone: String
)

data class CheckAuthCodeRequest(
    val phone: String,
    val code: String
)

data class RegisterRequest(
    val phone: String,
    val name: String,
    val username: String
)

