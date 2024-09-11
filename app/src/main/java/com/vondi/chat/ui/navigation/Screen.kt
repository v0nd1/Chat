package com.vondi.chat.ui.navigation

sealed class Screen(
    val route: String
) {
    data object Auth: Screen(
        route = "auth"
    )

    data object CountryChoose : Screen(
        route = "country_choose"
    )

    data object Chat : Screen(
        route = "chat"
    )

    data object CheckCode : Screen(
        route = "check_code"
    )

    data object Register : Screen(
        route = "register"
    )

}