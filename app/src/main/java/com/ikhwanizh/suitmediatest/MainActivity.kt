package com.ikhwanizh.suitmediatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ikhwanizh.suitmediatest.ui.FirstActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@MainActivity, FirstActivity::class.java))
        }, 3000)

        setContentView(R.layout.activity_main)
    }
}