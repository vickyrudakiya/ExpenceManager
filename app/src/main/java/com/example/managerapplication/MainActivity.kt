package com.example.managerapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.managerapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var Binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        initview()
    }

    private fun initview() {

        Binding.ACCEPT.setOnClickListener {

            var I = Intent(this,HomeActivity::class.java)
            startActivity(I)
        }
        Binding.termsofservice.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.google.com/")
            startActivity(openURL)
        }
        Binding.privcy.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.google.com/")
            startActivity(openURL)
        }
        Binding.permision.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.google.com/")
            startActivity(openURL)
        }



    }
}