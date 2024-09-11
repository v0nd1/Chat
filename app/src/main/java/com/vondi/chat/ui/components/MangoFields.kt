package com.vondi.chat.ui.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vondi.chat.domain.event.AuthEvent
import com.vondi.chat.ui.common.Background
import com.vondi.chat.ui.common.Error
import com.vondi.chat.ui.common.Primary
import com.vondi.chat.ui.common.Secondary
import com.vondi.chat.ui.common.Size
import com.vondi.chat.ui.theme.Roboto
import com.vondi.chat.ui.util.CountryNumber
import com.vondi.chat.ui.util.MaskVisualTransformation

@Composable
fun MangoFieldNumber(
    placeholder: String,
    onCountry: () -> Unit,
    country: CountryNumber,
    onEvent: (AuthEvent) -> Unit,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    var value by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value ,
        onValueChange = {
            when {
                it.length == country.length -> {
                    value = it.filter { it.isDigit() }
                    onEvent(AuthEvent.NumberFull("${country.code}$value"))
                }

                it.length < country.length -> {
                    value = it.filter { it.isDigit() }
                    onEvent(AuthEvent.NumberNotFull)
                }

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
        leadingIcon = {
            IconButton(
                onClick = onCountry
            ) {
                Text(country.flagEmoji)
            }
        },
        visualTransformation = MaskVisualTransformation("${country.code} ${country.mask}")
    )
}

@Composable
fun MangoTextField(
    placeholder: String,
    value: String,
    onValueChanged: (String) -> Unit,
    readOnly: Boolean = false,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    OutlinedTextField(
        readOnly = readOnly,
        modifier = modifier.fillMaxWidth(),
        value = value ,
        onValueChange = onValueChanged,
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
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {

            }
        )
    )
}



@Composable
fun CodeField(
    length: Int = 6,
    modifier: Modifier = Modifier,
    boxWidth: Dp = 40.dp,
    boxHeight: Dp = 50.dp,
    onEvent: (AuthEvent) -> Unit,
    spaceBetweenBoxes: Dp = 14.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions(),
) {
    var value by remember {
        mutableStateOf("")
    }
    BasicTextField(
        modifier = modifier,
        value = value,
        singleLine = true,
        onValueChange = {
            when {
                it.length == length -> {
                    value = it.filter { it.isDigit() }
                    onEvent(AuthEvent.CodeFull(value))
                }

                it.length < length -> {
                    value = it.filter { it.isDigit() }
                    onEvent(AuthEvent.CodeNotFull)
                }

            }
        },
        enabled = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        decorationBox = {
            Row(
                Modifier.
                size(width = (boxWidth + spaceBetweenBoxes) * length, height = boxHeight),
                horizontalArrangement = Arrangement.spacedBy(spaceBetweenBoxes),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(length) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Background,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .size(boxWidth, boxHeight)
                            .border(
                                1.dp,
                                color = Primary,
                                shape = RoundedCornerShape(10.dp)
                            ),

                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = value.getOrNull(it)?.toString() ?: "",
                            textAlign = TextAlign.Center,
                            fontFamily = Roboto,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    )
}

