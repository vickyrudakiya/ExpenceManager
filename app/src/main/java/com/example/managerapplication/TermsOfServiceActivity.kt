package com.example.managerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.managerapplication.databinding.ActivityTermsOfServiceBinding

class TermsOfServiceActivity : AppCompatActivity() {
    lateinit var Binding : ActivityTermsOfServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Binding = ActivityTermsOfServiceBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(Binding.root)

        initview()
    }

    private fun initview() {

        
    }
}