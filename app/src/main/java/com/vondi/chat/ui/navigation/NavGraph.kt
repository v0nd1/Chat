package com.vondi.chat.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vondi.chat.ui.screens.AuthScreen
import com.vondi.chat.ui.screens.ChatScreen
import com.vondi.chat.ui.screens.CheckCodeScreen
import com.vondi.chat.ui.screens.CountryScreen
import com.vondi.chat.ui.screens.RegisterScreen
import com.vondi.chat.ui.util.CountryNumber
import com.vondi.chat.ui.viewmodels.AuthViewModel

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel
) {
    val authState by authViewModel.state.collectAsState()
    NavHost(
        navController = navController,
        startDestination = Screen.Auth.route
    ) {
        composable(Screen.Auth.route){
            AuthScreen(
                navController =  navController,
                state = authState,
                authViewModel = authViewModel
            )
        }

        composable(Screen.CountryChoose.route){
            CountryScreen(
                navController = navController,
                onEvent = authViewModel::onEvent,
                countries = CountryNumber.getAllCountries()
            )
        }

        composable(Screen.Chat.route) {
            ChatScreen()
        }

        composable(Screen.CheckCode.route) {
            CheckCodeScreen(
                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable(Screen.Register.route) {
            RegisterScreen(
                authViewModel = authViewModel,
                navController = navController
            )
        }

    }
}