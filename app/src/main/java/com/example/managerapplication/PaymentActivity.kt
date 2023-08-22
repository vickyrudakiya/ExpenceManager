package com.example.managerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.managerapplication.Class.DatabaseHelperClass
import com.example.managerapplication.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    lateinit var binding : ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {


        var database = DatabaseHelperClass(this, "Database.db", null,1)
        binding.btnapplyPayment.setOnClickListener {

        }
        binding.btnapplyPayment.setOnClickListener {
            val name = binding.edtnamePayment.text.toString()

            if (name.isEmpty())
            {

                Toast.makeText(this, "Please Enter Your Payment Mode", Toast.LENGTH_SHORT).show()
            }
            else {
                database.InsertModeData(name)
                Toast.makeText(this, "Your Data Add SuccesFully", Toast.LENGTH_SHORT).show()
            }

        }




        binding.imgBack.setOnClickListener {

            onBackPressed()
        }
    }
}