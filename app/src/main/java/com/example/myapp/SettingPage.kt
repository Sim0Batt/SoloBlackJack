package com.example.myapp

import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.widget.Switch
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class SettingPage : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_page)
        val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager


        val volumeSwitch = findViewById<Switch>(R.id.volumeSwitch)
        volumeSwitch.setOnClickListener{
            if (volumeSwitch.isChecked){
                audioManager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
            }else{
                audioManager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
            }
        }



    }
}