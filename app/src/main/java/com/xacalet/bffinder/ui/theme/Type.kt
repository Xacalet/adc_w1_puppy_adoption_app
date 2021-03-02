package com.xacalet.bffinder.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.xacalet.bffinder.R

val NexaFontFamily = FontFamily(
    Font(R.font.nexa_light, FontWeight.Normal),
    Font(R.font.nexa_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = NexaFontFamily,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
    ),
    h2 = TextStyle(
        fontFamily = NexaFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    ),
    subtitle1 = TextStyle(
        fontFamily = NexaFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontFamily = NexaFontFamily,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp
    )
)