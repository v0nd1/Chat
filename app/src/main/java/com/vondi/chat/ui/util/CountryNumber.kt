package com.vondi.chat.ui.util

sealed class CountryNumber(
    val flagEmoji: String, // Эмодзи флага
    val country: String,
    val code: String,
    val mask: String
) {
    data object Russia : CountryNumber(
        flagEmoji = "\uD83C\uDDF7\uD83C\uDDFA", // 🇷🇺
        country = "Россия",
        code = "+7",
        mask = "(###) ###-##-##"
    )

    data object USA : CountryNumber(
        flagEmoji = "\uD83C\uDDFA\uD83C\uDDF8", // 🇺🇸
        country = "США",
        code = "+1",
        mask = "(###) ###-####"
    )

    data object UK : CountryNumber(
        flagEmoji = "\uD83C\uDDEC\uD83C\uDDE7", // 🇬🇧
        country = "Великобритания",
        code = "+44",
        mask = "#### ### ####"
    )

    data object Germany : CountryNumber(
        flagEmoji = "\uD83C\uDDE9\uD83C\uDDEA", // 🇩🇪
        country = "Германия",
        code = "+49",
        mask = "#### ########"
    )

    data object France : CountryNumber(
        flagEmoji = "\uD83C\uDDE8\uD83C\uDDF7", // 🇫🇷
        country = "Франция",
        code = "+33",
        mask = "## ## ## ## ##"
    )

    data object China : CountryNumber(
        flagEmoji = "\uD83C\uDDE8\uD83C\uDDF3", // 🇨🇳
        country = "Китай",
        code = "+86",
        mask = "### #### ####"
    )

    data object India : CountryNumber(
        flagEmoji = "\uD83C\uDDEE\uD83C\uDDF3", // 🇮🇳
        country = "Индия",
        code = "+91",
        mask = "#####-#####"
    )

    companion object {
        fun getAllCountries(): List<CountryNumber> {
            return listOf(
                Russia,
                USA,
                UK,
                Germany,
                France,
                China,
                India
            )
        }
    }
}