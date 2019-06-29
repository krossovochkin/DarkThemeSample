package com.krossovochkin.darkthemesample.theme

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate.*
import com.krossovochkin.darkthemesample.R

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

fun getThemeOptions(): Array<CharSequence> {
    return if (Build.VERSION.SDK_INT >= 28) {
        arrayOf(LIGHT, DARK, SYSTEM_DEFAULT)
    } else {
        arrayOf(LIGHT, DARK, DARK_BATTERY_SAVE)
    }
}

fun getThemeOptionNames(context: Context): Array<CharSequence> {
    return if (Build.VERSION.SDK_INT >= 28) {
        arrayOf(
            context.getString(R.string.theme_option_light),
            context.getString(R.string.theme_option_dark),
            context.getString(R.string.theme_option_system)
        )
    } else {
        arrayOf(
            context.getString(R.string.theme_option_light),
            context.getString(R.string.theme_option_dark),
            context.getString(R.string.theme_option_battery)
        )
    }
}

private const val LIGHT = "light"
private const val DARK = "dark"
private const val DARK_BATTERY_SAVE = "dark_battery_save"
private const val SYSTEM_DEFAULT = "system_default"