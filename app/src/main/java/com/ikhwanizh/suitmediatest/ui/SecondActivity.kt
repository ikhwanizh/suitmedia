package com.ikhwanizh.suitmediatest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ikhwanizh.suitmediatest.R
import com.ikhwanizh.suitmediatest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)

        init()

        setContentView(binding.root)
    }

    private fun init() {
        binding.apply {
            val name = intent.getStringExtra("name")
            tvName.text = name

            val user_name = intent.getStringExtra("first_name") + " " + intent.getStringExtra("last_name")
            tvPalindrome.text = user_name

            btnSelectUsser.setOnClickListener {
                startActivity(Intent(this@SecondActivity, ThirdActivity::class.java))
            }

            btnBack.setOnClickListener {
                startActivity(Intent(this@SecondActivity, FirstActivity::class.java))
            }
        }
    }
}