package com.example.managerapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import com.example.managerapplication.Adapter.CatAdapter
import com.example.managerapplication.Adapter.ModeAdapter
import com.example.managerapplication.Class.DatabaseHelperClass
import com.example.managerapplication.Mode.ModeModelClass
import com.example.managerapplication.Mode.ModelClass
import com.example.managerapplication.databinding.ActivityIncomeBinding
import java.text.SimpleDateFormat
import java.util.*

class IncomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityIncomeBinding
    var Categorylist = ArrayList<ModelClass>()
    var Modelist = ArrayList<ModeModelClass>()
    lateinit var database: DatabaseHelperClass
    lateinit var c : String
    lateinit var  m : String


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityIncomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        database = DatabaseHelperClass(this, "Database.db", null,1)



        initview()
    }


    private fun initview() {




        binding.imgBack.setOnClickListener {

            onBackPressed()
        }


//        for calander view

        val myCalendar = Calendar.getInstance()
        val datapicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofmonth ->

            myCalendar.set(Calendar.DAY_OF_MONTH, dayofmonth)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.YEAR, year)
            updateLabal(myCalendar)

        }


        binding.txtDate.setOnClickListener {

            DatePickerDialog(
                this, datapicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }


        //for time picker


        binding.txtTime.setOnClickListener {

            val calendar = Calendar.getInstance()
            val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
            val currentMinute = calendar.get(Calendar.MINUTE)

            val textView: TextView = findViewById(com.example.managerapplication.R.id.txtTime)


            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    val selectedTime = String.format("%02d:%02d", currentHour, minute)
                    textView.text = selectedTime
                },
                currentHour,
                currentMinute,
                false
            )

            timePickerDialog.show()

        }


        Categorylist = database.DisplayCategory()


        var adapter = CatAdapter(this, Categorylist)
        binding.SpinnerCategory.adapter = adapter



        Modelist = database.DisplayMode()
        var Madapter = ModeAdapter(this, Modelist)
        binding.spinnerMode.adapter = Madapter

//        for Add Category

        binding.SpinnerCategory.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                c= Categorylist[position].Category


                Toast.makeText(this@IncomeActivity, "You Select : " +c , Toast.LENGTH_SHORT).show()


            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }


//        for Add Mode


        binding.spinnerMode.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                m= Modelist[position].name


                Toast.makeText(this@IncomeActivity, "You Select : " +m , Toast.LENGTH_SHORT).show()


            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        //        for insert table

        binding.imgDone.setOnClickListener {
            val amt = binding.edtAmount.text.toString().toInt()
//            val category = binding.txtitemCategories.text.toString()
            val date = binding.txtDate.text.toString()
//            val mode = binding.txtMode.text.toString()
            val note = binding.edtNote.text.toString()
            val time = binding.txtTime.text.toString()
            if (amt==null)
            {
                Toast.makeText(this, "Please Enter Your Amount Name ", Toast.LENGTH_SHORT).show()
            }

            else if (c==null)
            {

                Toast.makeText(this, "Please Enter Your Category Name ", Toast.LENGTH_SHORT).show()
            }


            else if (date==null)
            {

                Toast.makeText(this, "Please Enter Your Date  ", Toast.LENGTH_SHORT).show()
            }


            else if (time.isEmpty())
            {

                Toast.makeText(this, "Please Enter Your time  ", Toast.LENGTH_SHORT).show()
            }


            else if (m==null)
            {

                Toast.makeText(this, "Please Enter Your Mode Name ", Toast.LENGTH_SHORT).show()
            }


            else if (note==null)
            {

                Toast.makeText(this, "Please Enter note  Name ", Toast.LENGTH_SHORT).show()
            }


            else
            {

//                Log.e("TAG", "insert data : "+amt+"  "+c+"  "+m+"  "+date+"  "+note )


                database.InsertTableData(amt.toString() ,c,m,date,note)
               Toast.makeText(this, "Your Data Add SuccesFully", Toast.LENGTH_SHORT).show()
            }
        }




    }


    //for date
    fun updateLabal(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.txtDate.setText(sdf.format(myCalendar.time))
    }
}



