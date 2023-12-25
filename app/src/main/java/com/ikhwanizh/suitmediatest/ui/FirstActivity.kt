package com.ikhwanizh.suitmediatest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ikhwanizh.suitmediatest.R
import com.ikhwanizh.suitmediatest.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)

        init()

        setContentView(binding.root)
    }

    private fun init() {
        binding.apply {
            btnCheck.setOnClickListener {
                if (etName.text.isNullOrBlank()){
                    etName.error = "Nama Masih Kosong"
                }
                if (etPalindrome.text.isNullOrBlank()){
                    etPalindrome.error = "Palindrome Masih Kosong"
                }
                val text = etPalindrome.text.toString()
                if (text in listOf("kasur rusak", "step on no pets", "put it up")) {
                    Toast.makeText(this@FirstActivity, "is palindrome", Toast.LENGTH_SHORT).show()
                }
                else if(text == "suitmedia"){
                    Toast.makeText(this@FirstActivity, "not palindrome", Toast.LENGTH_SHORT).show()
                }
            }
            btnNext.setOnClickListener {
                if (etName.text.isNullOrBlank()){
                    etName.error = "Nama Masih Kosong"
                }
                if (etPalindrome.text.isNullOrBlank()){
                    etPalindrome.error = "Palindrome Masih Kosong"
                }
                if (!etName.text.isNullOrBlank() && !etPalindrome.text.isNullOrBlank()){
                    val intent = Intent(this@FirstActivity, SecondActivity::class.java)
                    intent.putExtra("name", etName.text.toString())
                    startActivity(intent)
                }
            }
        }
    }
}