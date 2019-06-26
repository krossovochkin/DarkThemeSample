package com.krossovochkin.darkthemesample

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.krossovochkin.darkthemesample.theme.getDefaultThemeKey
import com.krossovochkin.darkthemesample.theme.resolveTheme

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initTheme()
    }

    private fun initTheme() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val themePreferenceKey = getString(R.string.theme_preference_key)
        val themeKey = preferences.getString(themePreferenceKey,
            getDefaultThemeKey()
        )
        preferences.edit().putString(themePreferenceKey, themeKey).apply()

        AppCompatDelegate.setDefaultNightMode(resolveTheme(themeKey))
    }
}