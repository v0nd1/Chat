package com.vondi.chat.domain.event

import com.vondi.chat.ui.util.CountryNumber

sealed interface AuthEvent {

    data class ChooseCountry(val country: CountryNumber) : AuthEvent
    data class NumberFull(val number: String) : AuthEvent
    data object NumberNotFull : AuthEvent
    data object IsSuccessAuthSend : AuthEvent
    data object IsNotSuccessAuthSend : AuthEvent
    data class CodeFull(val code: String) : AuthEvent
    data object CodeNotFull : AuthEvent
    data object RegFull : AuthEvent
    data object RegNotFull : AuthEvent
    data object RegSuccess : AuthEvent
    data object RegNotSuccess : AuthEvent
    data class SetUserName(val username: String) : AuthEvent
    data class SetName(val name: String) : AuthEvent
}