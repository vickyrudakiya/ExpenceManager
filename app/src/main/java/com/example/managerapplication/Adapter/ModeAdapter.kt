package com.example.managerapplication.Adapter

import android.content.Context
import android.icu.text.Normalizer2.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.managerapplication.Mode.ModeModelClass
import com.example.managerapplication.R

class ModeAdapter(var PaymentActivity : Context,var Modelist: ArrayList<ModeModelClass>) : BaseAdapter() {
    override fun getCount(): Int {
        return Modelist.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var v: View = LayoutInflater.from(PaymentActivity).inflate(R.layout.mode_item_file,null)
            var Mode = v.findViewById<TextView>(R.id.txtMode)
            Mode.text = Modelist[p0].name
            return v
    }
}