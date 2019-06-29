package com.krossovochkin.darkthemesample.theme

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.krossovochkin.darkthemesample.R

class AppPreferences : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        context?.let { setupThemePreference(it, rootKey) }
    }

    private fun setupThemePreference(context: Context, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        val themePreference = findPreference<ListPreference>(getString(R.string.theme_preference_key))

        themePreference?.entries = getThemeOptionNames(context)

        themePreference?.entryValues = getThemeOptions()

        themePreference?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
            AppCompatDelegate.setDefaultNightMode(resolveTheme(newValue as String))
            true
        }
    }
}