package com.example.myapplication

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val value =
            requestWindowFeature(Window.FEATURE_NO_TITLE)
        window . setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


}