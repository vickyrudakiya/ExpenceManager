package com.example.managerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.managerapplication.databinding.ActivityCalenderBinding

class CalenderActivity : AppCompatActivity() {
    lateinit var Binding : ActivityCalenderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Binding=ActivityCalenderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(Binding.root)
    }

}