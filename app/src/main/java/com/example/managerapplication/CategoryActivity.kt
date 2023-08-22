package com.example.managerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.managerapplication.Class.DatabaseHelperClass
import com.example.managerapplication.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    lateinit var Binding : ActivityCategoryBinding
    lateinit var database: DatabaseHelperClass
    override fun onCreate(savedInstanceState: Bundle?) {
        Binding= ActivityCategoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(Binding.root)

        database = DatabaseHelperClass(this, "Database.db", null,1)
        initview()
    }

    private fun initview() {

         database = DatabaseHelperClass(this, "Database.db", null,1)
        Binding.btnapplyCategory.setOnClickListener {
            val name = Binding.edtnameCategory.text.toString()
            if (name.isEmpty())
            {

                Toast.makeText(this, "Please Enter Your Category Name ", Toast.LENGTH_SHORT).show()
            }

            else
            {
                database.InsertData(name)
                Toast.makeText(this, "Your Data Add SuccesFully", Toast.LENGTH_SHORT).show()
            }

        }

//        Binding.imgBack.setOnClickListener {
//
//            onBackPressed()
//        }


    }
}