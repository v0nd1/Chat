package com.vondi.chat.domain.model

import com.vondi.chat.ui.util.CountryNumber

data class AuthState(
    val country: CountryNumber = CountryNumber.Russia,
    val isNumberFull: Boolean = false,
    val isCodeFull: Boolean = false,
    val number: String = "",
    val code: String = "",
    val username: String = "",
    val name: String = "",
    val isAuthSend: Boolean = false,
    val isCorrectCode: Boolean = false,
    val isUserExist: Boolean = false,
    val isRegFull: Boolean = false,
    val isRegSuccess: Boolean = false,
)