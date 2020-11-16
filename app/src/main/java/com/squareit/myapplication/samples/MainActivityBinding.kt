package com.squareit.myapplication.samples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareit.myapplication.R

class MainActivityBinding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}