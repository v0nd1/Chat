package com.vondi.chat.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vondi.chat.data.remote.MangoApi
import com.vondi.chat.domain.event.AuthEvent
import com.vondi.chat.domain.model.AuthState
import com.vondi.chat.domain.model.CheckAuthCodeRequest
import com.vondi.chat.domain.model.RegisterRequest
import com.vondi.chat.domain.model.SendAuthCodeRequest
import com.vondi.chat.ui.util.TokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val mangoApi: MangoApi,
    private val tokenManager: TokenManager
) : ViewModel() {
    private val tag = "AuthViewModel"
    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state

    fun sendAuthCode(phone: String) {
        viewModelScope.launch {
            val request = SendAuthCodeRequest(phone)
            try {
                val response = mangoApi.sendAuthCode(request)
                Log.d(tag, "Response $response")
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null && body.isSuccess) {
                        Log.d(tag, "Success $body")
                        onEvent(AuthEvent.IsSuccessAuthSend)
                        Log.d(tag, "${state.value.isAuthSend}")
                    } else {
                        Log.d(tag, "Failure $body")
                        onEvent(AuthEvent.IsNotSuccessAuthSend)
                    }
                } else {
                    Log.d(tag, "Failure $response")
                    onEvent(AuthEvent.IsNotSuccessAuthSend)
                }
            } catch (e: Exception) {
                Log.d(tag, "Failure $e")
                onEvent(AuthEvent.IsNotSuccessAuthSend)
            }
        }
    }

    fun checkAuthCode(phone: String, code: String) {
        viewModelScope.launch {
            val request = CheckAuthCodeRequest(phone, code)
            try {
                val response = mangoApi.checkAuthCode(request)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        when(body.isUserExists) {
                            false -> {
                                _state.update {
                                    it.copy(
                                        isCorrectCode = true,
                                        isUserExist = false,
                                    )
                                }
                            }
                            true -> {
                                _state.update {
                                    it.copy(
                                        isCorrectCode = true,
                                        isUserExist = true,
                                    )
                                }
                                val accessToken = body.accessToken
                                val refreshToken = body.refreshToken
                                val userId = body.userId
                                if (accessToken != null && refreshToken != null && userId != null) {
                                    tokenManager.saveTokens(accessToken, refreshToken, userId)
                                    Log.d(tag, "register success: $body")
                                } else {
                                    Log.d(tag, "register error: accessToken or refreshToken is null")
                                }
                            }
                        }

                    } else {
                        _state.update {
                            it.copy(
                                isCorrectCode = false
                            )
                        }
                    }
                } else {
                    _state.update {
                        it.copy(
                            isCorrectCode = false
                        )
                    }
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isCorrectCode = false
                    )
                }
            }
        }
    }

    fun register(
        phone: String,
        name: String,
        username: String
    ){
        val request = RegisterRequest(phone, name, username)
        viewModelScope.launch {
            try {
                val response = mangoApi.register(request)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        val accessToken = body.accessToken
                        val refreshToken = body.refreshToken
                        val userId = body.userId
                        if (accessToken != null && refreshToken != null && userId != null) {
                            tokenManager.saveTokens(accessToken, refreshToken, userId)
                            onEvent(AuthEvent.RegSuccess)
                            Log.d(tag, "register success: $body")
                        } else {
                            onEvent(AuthEvent.RegNotSuccess)
                            Log.d(tag, "register error: accessToken or refreshToken is null")
                        }
                    } else {
                        onEvent(AuthEvent.RegNotSuccess)
                        Log.d(tag, "register err $body")
                    }
                } else {
                    onEvent(AuthEvent.RegNotSuccess)
                    Log.d(tag, "register err $response")
                }
            } catch (e: Exception) {
                onEvent(AuthEvent.RegNotSuccess)
                Log.d(tag, "register err $e")
            }
        }
    }

    fun refreshToken(refreshToken: String) {
        viewModelScope.launch {
            try {
                val response = mangoApi.refreshToken("Bearer $refreshToken")
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        val accessToken = body.accessToken
                        val refreshToken = body.refreshToken
                        val userId = body.userId
                        if (accessToken != null && refreshToken != null && userId != null) {
                            tokenManager.saveTokens(accessToken, refreshToken, userId)
                            Log.d(tag, "register success: $body")
                        } else {
                            Log.d(tag, "register error: accessToken or refreshToken is null")
                        }
                    } else {
                        Log.d(tag, "register error: $body")
                    }
                } else {
                    Log.d(tag, "register error: $response")
                }
            } catch (e: Exception) {
                Log.d(tag, "register error: $e")
            }
        }
    }


    fun onEvent(event: AuthEvent) {
        when(event){
            is AuthEvent.ChooseCountry -> {
                _state.update {
                    it.copy(
                        country = event.country
                    )
                }
            }

            is AuthEvent.NumberFull -> {
                _state.update {
                    it.copy(
                        isNumberFull = true,
                        number = event.number
                    )
                }
            }

            AuthEvent.NumberNotFull -> {
                _state.update {
                    it.copy(
                        isNumberFull = false,

                    )
                }
            }

            AuthEvent.IsSuccessAuthSend -> {
                _state.update {
                    it.copy(
                        isAuthSend = true
                    )
                }
            }

            AuthEvent.IsNotSuccessAuthSend -> {
                _state.update {
                    it.copy(
                        isAuthSend = false
                    )
                }
            }

            is AuthEvent.CodeFull -> {
                _state.update {
                    it.copy(
                        isCodeFull = true,
                        code = event.code
                    )
                }
            }

            AuthEvent.CodeNotFull -> {
                _state.update {
                    it.copy(
                        isCodeFull = false
                    )
                }
            }

            is AuthEvent.SetName -> {
                _state.update {
                    it.copy(
                        name = event.name
                    )
                }
            }

            is AuthEvent.SetUserName -> {
                _state.update {
                    it.copy(
                        username = event.username
                    )
                }
            }

            AuthEvent.RegFull -> {
                _state.update {
                    it.copy(
                        isRegFull = true
                    )
                }
            }

            AuthEvent.RegNotFull -> {
                _state.update {
                    it.copy(
                        isRegFull = false
                    )
                }
            }

            AuthEvent.RegSuccess -> {
                _state.update {
                    it.copy(
                        isRegSuccess = true
                    )
                }
            }

            AuthEvent.RegNotSuccess -> {
                _state.update {
                    it.copy(
                        isRegSuccess = false
                    )
                }
            }
        }
    }


}