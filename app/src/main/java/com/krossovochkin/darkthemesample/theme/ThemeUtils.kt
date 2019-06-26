package com.krossovochkin.darkthemesample.theme

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate.*

@NightMode
fun resolveTheme(key: String?): Int = when (key) {
    LIGHT -> MODE_NIGHT_NO
    DARK -> MODE_NIGHT_YES
    DARK_BATTERY_SAVE -> MODE_NIGHT_AUTO_BATTERY
    SYSTEM_DEFAULT -> MODE_NIGHT_FOLLOW_SYSTEM
    else -> throw IllegalArgumentException("Unknown theme key: $key")
}

fun getDefaultThemeKey(): String {
    return if (Build.VERSION.SDK_INT >= 28) {
        SYSTEM_DEFAULT
    } else {
        DARK_BATTERY_SAVE
    }
}

private const val LIGHT = "light"
private const val DARK = "dark"
private const val DARK_BATTERY_SAVE = "dark_battery_save"
private const val SYSTEM_DEFAULT = "system_default"