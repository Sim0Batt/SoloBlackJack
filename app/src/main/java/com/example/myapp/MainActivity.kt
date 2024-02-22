package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.view.View
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startButton)
        startBtn.setOnClickListener{
            val intent = Intent(this, StartingMain::class.java)
            startActivity(intent)
        }

        val settingsBtn= findViewById<Button>(R.id.settingButton)
        settingsBtn.setOnClickListener{
            val intent2 = Intent(this, SettingPage::class.java)

            startActivity(intent2)
        }
    }
}