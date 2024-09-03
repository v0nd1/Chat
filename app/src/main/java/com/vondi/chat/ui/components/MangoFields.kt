package com.vondi.chat.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.vondi.chat.ui.common.Primary
import com.vondi.chat.ui.common.Secondary
import com.vondi.chat.ui.common.Size
import com.vondi.chat.ui.components.NumberDefaults.INPUT_LENGTH
import com.vondi.chat.ui.theme.Roboto
import com.vondi.chat.ui.util.MaskVisualTransformation

@Composable
fun MangoFieldNumber(
    placeholder: String,
    errorStatus: Boolean = false,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    var value by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value ,
        onValueChange = {
            if (it.length <= INPUT_LENGTH) {
                value = it.filter { it.isDigit() }
            }
        },
        shape = RoundedCornerShape(Size.ExtraSmall),
        placeholder = {
            Text(
                text = placeholder,
                color = Secondary,
                fontFamily = Roboto
            )
        },
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Primary,
            focusedBorderColor = Primary,
            focusedContainerColor = Transparent,
            unfocusedContainerColor = Transparent,
            errorContainerColor = Transparent

        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {

            }
        ),
        visualTransformation = MaskVisualTransformation(NumberDefaults.MASK)
    )
}

@Composable
fun MangoPickCountry(
    placeholder: String,
    errorStatus: Boolean = false,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    var value by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value ,
        onValueChange = {
            if (it.length <= INPUT_LENGTH) {
                value = it.filter { it.isDigit() }
            }
        },
        shape = RoundedCornerShape(Size.ExtraSmall),
        placeholder = {
            Text(
                text = placeholder,
                color = Secondary,
                fontFamily = Roboto
            )
        },
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Primary,
            focusedBorderColor = Primary,
            focusedContainerColor = Transparent,
            unfocusedContainerColor = Transparent,
            errorContainerColor = Transparent

        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {

            }
        ),
        visualTransformation = MaskVisualTransformation(NumberDefaults.MASK)
    )
}





const val text = "+7"

object NumberDefaults {
    const val MASK = "$text (###) ###-##-##"
    const val INPUT_LENGTH = 10
}