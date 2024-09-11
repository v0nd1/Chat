package com.vondi.chat.ui.util

import android.content.Context

class TokenManager(private val context: Context) {

    companion object {
        private const val PREFS_NAME = "AuthPrefs"
        private const val ACCESS_TOKEN = "accessToken"
        private const val REFRESH_TOKEN = "refreshToken"
        private const val USER_ID = "userId"
    }

    fun saveTokens(accessToken: String, refreshToken: String, userId: Int) {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString(ACCESS_TOKEN, accessToken)
            putString(REFRESH_TOKEN, refreshToken)
            putInt(USER_ID, userId)
            apply()
        }
    }

    fun getAccessToken(): String? {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(ACCESS_TOKEN, null)
    }

    fun getRefreshToken(): String? {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(REFRESH_TOKEN, null)
    }

    fun getUserId(): Int {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(USER_ID, -1)
    }

    fun clearTokens() {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            remove(ACCESS_TOKEN)
            remove(REFRESH_TOKEN)
            remove(USER_ID)
            apply()
        }
    }
}
