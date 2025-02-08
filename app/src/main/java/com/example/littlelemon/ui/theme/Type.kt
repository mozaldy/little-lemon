package com.example.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import androidx.compose.ui.text.font.Font

// Set of Material typography styles to start with

val MarkaziTextFamily = FontFamily(
    Font(R.font.markazi_text_regular, weight = FontWeight.Normal),
    Font(R.font.markazi_text_medium, weight = FontWeight.Medium),
    Font(R.font.markazi_text_semibold, weight = FontWeight.SemiBold),
    Font(R.font.markazi_text_bold, weight = FontWeight.Bold)
)

val KarlaFamily = FontFamily(
    Font(R.font.karla_regular, weight = FontWeight.Normal),
    Font(R.font.karla_medium, weight = FontWeight.Medium),
    Font(R.font.karla_semibold, weight = FontWeight.SemiBold),
    Font(R.font.karla_bold, weight = FontWeight.Bold)
)


val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 64.sp,
        fontWeight = FontWeight.Medium,
        color = LittleLemonColor.yellow,
        fontFamily = MarkaziTextFamily
    ),
    displayMedium = TextStyle(
        fontSize = 38.sp,
        fontWeight = FontWeight.Normal,
        color = LittleLemonColor.cloud,
        fontFamily = MarkaziTextFamily
    ),
    displaySmall = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        color = LittleLemonColor.cloud,
        fontFamily = MarkaziTextFamily
    ),
    headlineLarge = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.charcoal,
        fontFamily = KarlaFamily,
    ),
    headlineMedium = TextStyle(
        color = LittleLemonColor.charcoal,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = KarlaFamily
    ),
    bodyLarge = TextStyle(
        color = LittleLemonColor.green
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.green
    ),
    headlineSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
)


