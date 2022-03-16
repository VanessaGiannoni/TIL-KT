package com.example.aula_5_calculadora_churrasco

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR

        supportFragmentManager.beginTransaction()
            .add(R.id.mainLayout, FormFragment(), "FormFragment").commit();
    }
}