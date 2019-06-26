package com.krossovochkin.darkthemesample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.krossovochkin.darkthemesample.activity.DayNightActivity
import com.krossovochkin.darkthemesample.activity.DefaultActivity
import com.krossovochkin.darkthemesample.activity.ForceDarkActivity
import com.krossovochkin.darkthemesample.activity.NoDarkActivity
import com.krossovochkin.darkthemesample.theme.AppPreferences

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.appPreferencesContainer,
            AppPreferences()
        ).commit()

        findViewById<Button>(R.id.buttonDefault).setOnClickListener {
            startActivity(Intent(this, DefaultActivity::class.java))
        }

        findViewById<Button>(R.id.buttonDayNight).setOnClickListener {
            startActivity(Intent(this, DayNightActivity::class.java))
        }

        findViewById<Button>(R.id.buttonForceDark).setOnClickListener {
            startActivity(Intent(this, ForceDarkActivity::class.java))
        }

        findViewById<Button>(R.id.buttonNoDark).setOnClickListener {
            startActivity(Intent(this, NoDarkActivity::class.java))
        }
    }
}
