package com.vondi.chat.ui.util

sealed class CountryNumber(
    val flagEmoji: String, // Эмодзи флага
    val country: String,
    val code: String,
    val mask: String,
    val length: Int
) {
    data object Russia : CountryNumber(
        flagEmoji = "\uD83C\uDDF7\uD83C\uDDFA",
        country = "Россия",
        code = "+7",
        mask = "(###) ###-##-##",
        length = 10
    )

    data object USA : CountryNumber(
        flagEmoji = "\uD83C\uDDFA\uD83C\uDDF8",
        country = "США",
        code = "+1",
        mask = "(###) ###-####",
        length = 10
    )

    data object UK : CountryNumber(
        flagEmoji = "\uD83C\uDDEC\uD83C\uDDE7",
        country = "Великобритания",
        code = "+44",
        mask = "#### ### ####",
        length = 11
    )

    data object Germany : CountryNumber(
        flagEmoji = "\uD83C\uDDE9\uD83C\uDDEA",
        country = "Германия",
        code = "+49",
        mask = "#### ########",
        length = 12
    )

    data object France : CountryNumber(
        flagEmoji = "\uD83C\uDDE8\uD83C\uDDF7",
        country = "Франция",
        code = "+33",
        mask = "## ## ## ## ##",
        length = 10
    )

    data object China : CountryNumber(
        flagEmoji = "\uD83C\uDDE8\uD83C\uDDF3",
        country = "Китай",
        code = "+86",
        mask = "### #### ####",
        length = 11
    )

    data object India : CountryNumber(
        flagEmoji = "\uD83C\uDDEE\uD83C\uDDF3",
        country = "Индия",
        code = "+91",
        mask = "#####-#####",
        length = 10
    )
    data object Japan : CountryNumber(
        flagEmoji = "\uD83C\uDDEF\uD83C\uDDF5",
        country = "Япония",
        code = "+81",
        mask = "##-####-####",
        length = 10
    )

    data object Brazil : CountryNumber(
        flagEmoji = "\uD83C\uDDE7\uD83C\uDDF7",
        country = "Бразилия",
        code = "+55",
        mask = "(##) #####-####",
        length = 11
    )

    data object Australia : CountryNumber(
        flagEmoji = "\uD83C\uDDE6\uD83C\uDDFA",
        country = "Австралия",
        code = "+61",
        mask = "#### ### ###",
        length = 10
    )

    data object Canada : CountryNumber(
        flagEmoji = "\uD83C\uDDE8\uD83C\uDDE6",
        country = "Канада",
        code = "+1",
        mask = "(###) ###-####",
        length = 10
    )

    data object Italy : CountryNumber(
        flagEmoji = "\uD83C\uDDEE\uD83C\uDDF9",
        country = "Италия",
        code = "+39",
        mask = "### #######",
        length = 10
    )

    data object Mexico : CountryNumber(
        flagEmoji = "\uD83C\uDDF2\uD83C\uDDFD",
        country = "Мексика",
        code = "+52",
        mask = "## #### ####",
        length = 10
    )


    companion object {
        fun getAllCountries(): List<CountryNumber> {
            return listOf(
                Russia, USA, UK,
                Germany, France, China,
                India, Japan, Brazil,
                Canada, Italy, Mexico,
                Australia
            )
        }

    }
}