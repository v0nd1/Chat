package com.vondi.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.vondi.chat.ui.screens.auth.AuthScreen
import com.vondi.chat.ui.screens.auth.CountryScreen
import com.vondi.chat.ui.theme.ChatTheme
import com.vondi.chat.ui.util.CountryNumber
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatTheme {
                val countries = CountryNumber.getAllCountries()
                CountryScreen(navController = rememberNavController(), countries = countries )
                //AuthScreen(navController = rememberNavController())
            }
        }
    }
}

