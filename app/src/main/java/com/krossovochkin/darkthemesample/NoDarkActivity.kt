package com.krossovochkin.darkthemesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NoDarkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
    }
}
