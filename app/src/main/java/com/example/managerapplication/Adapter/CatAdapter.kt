package com.example.managerapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.managerapplication.IncomeActivity
import com.example.managerapplication.Mode.ModelClass
import com.example.managerapplication.R

class CatAdapter(var incomeActivity: Context,var CategoryList : java.util.ArrayList<ModelClass>) : BaseAdapter() {
    override fun getCount(): Int {

        return CategoryList.size

    }

    override fun getItem(p0: Int): Any? {

        return null
    }

    override fun getItemId(p0: Int): Long {

        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var v : View = LayoutInflater.from(incomeActivity).inflate(R.layout.category_item_file,null)
        var Category = v.findViewById<TextView>(R.id.txtitemCategories)
        Category.text=CategoryList[p0].Category
        return v
    }
}