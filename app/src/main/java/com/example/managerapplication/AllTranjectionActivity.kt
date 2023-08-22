package com.example.managerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.managerapplication.Adapter.DisplayAdapter
import com.example.managerapplication.Class.DatabaseHelperClass
import com.example.managerapplication.Mode.ModelClassDisplay
import com.example.managerapplication.databinding.ActivityAllTranjectionBinding

class AllTranjectionActivity : AppCompatActivity() {
    lateinit var Binding : ActivityAllTranjectionBinding
    var Displaylist = ArrayList<ModelClassDisplay>()
    lateinit var Dadapter : DisplayAdapter
    lateinit var database: DatabaseHelperClass
    override fun onCreate(savedInstanceState: Bundle?) {
        Binding = ActivityAllTranjectionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(Binding.root)


        initview()
    }


    private fun initview() {


        database = DatabaseHelperClass(this, "Database.db", null,1)
        database.Delete(5)
        Displaylist =  database.DisplayTableData()
        var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        Dadapter = DisplayAdapter(this,Displaylist)
        Binding.rcv.adapter = Dadapter
        Binding.rcv.layoutManager= manager

    }


    override fun onResume()
    {
        super.onResume()
        Displaylist = database.DisplayTableData()
        Dadapter.refresh(Displaylist)

    }}