package com.example.managerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.managerapplication.databinding.ActivityPrivacyBinding

class RateActivity : AppCompatActivity() {
    lateinit var Binding : ActivityPrivacyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityPrivacyBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        initview()
    }

    private fun initview() {

        Binding.btnSumbit.setOnClickListener {

            if (Binding.ratingbar != null) {
                val button = findViewById<AppCompatButton>(R.id.btnSumbit)
                button?.setOnClickListener {
                    val msg = Binding.ratingbar.rating.toString()
                    Toast.makeText(this@RateActivity,
                        "Rating is: "+msg, Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}