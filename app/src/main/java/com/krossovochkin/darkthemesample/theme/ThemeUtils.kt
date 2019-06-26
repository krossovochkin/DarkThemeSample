package com.krossovochkin.darkthemesample.theme

import androidx.appcompat.app.AppCompatDelegate.*

@NightMode
fun resolveTheme(key: String?): Int = when (key) {
    "light" -> MODE_NIGHT_NO
    "dark" -> MODE_NIGHT_YES
    "dark_battery_save" -> MODE_NIGHT_AUTO_BATTERY
    "system_default" -> MODE_NIGHT_FOLLOW_SYSTEM
    else -> throw IllegalArgumentException("Unknown theme key: $key")
}

fun getDefaultThemeKey(): String {
    return "system_default"
}