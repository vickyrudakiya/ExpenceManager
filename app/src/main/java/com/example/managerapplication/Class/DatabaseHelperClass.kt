package com.example.managerapplication.Class

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.managerapplication.Mode.ModeModelClass
import com.example.managerapplication.Mode.ModelClass
import com.example.managerapplication.Mode.ModelClassDisplay

class DatabaseHelperClass (context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {

        var ctable = "create table CategoryTable(id Integer primary key autoincrement,name text)"
        db?.execSQL(ctable)

        var Model = "create table ModeTable(id Integer primary key autoincrement,name text)"
        db?.execSQL(Model)

        var tbl =
            "create table IncomeExpenseTable(id Integer primary key autoincrement,amount Integer,category text,date text,mode text,type text,note text)"
        db?.execSQL(tbl)
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun InsertData(name : String) {

        var c = ContentValues()
        c.put("name", name)
        var write = writableDatabase
        var result = write.insert("CategoryTable", null, c)
        Log.e("TAG", "insertData: " + result)
    }

    fun InsertModeData(name: String) {
        var c = ContentValues()
        c.put("name", name)
        var write = writableDatabase
        var result = write.insert("ModeTable", null, c)
        Log.e("TAG", "InsertModeData: " + result)
    }

    fun DisplayCategory(): ArrayList<ModelClass> {


        var list = ArrayList<ModelClass>()

        list.clear()

        var read = readableDatabase

        var query = "select * from CategoryTable"

        var cursor: Cursor = read.rawQuery(query, null)

        cursor.moveToFirst()
        do {
            var id = cursor.getString(0)
            var name = cursor.getString(1)
            Log.e("TAG", "DisplayCategory: " + name)
            list.add(ModelClass(name, id))
        } while (cursor.moveToNext())
        return list

    }


    fun DisplayMode(): ArrayList<ModeModelClass> {

        var read = readableDatabase
        var modelist = ArrayList<ModeModelClass>()
        var query = "select * from ModeTable"
        var cursor: Cursor = read.rawQuery(query, null)
        cursor.moveToFirst()

        do {
             var id = cursor.getString(0)
            var name = cursor.getString(1)
            Log.e("TAG", "DisplayMode: " + name)
            modelist.add(ModeModelClass(name, id))
        } while (cursor.moveToNext())

        return modelist
    }


    fun InsertTableData(amount: String, category: String, mode: String, date: String, note: String )
    {




        var write = writableDatabase

        var c = ContentValues()
        c.put("amount", amount)
       c.put("category", category)
       c.put("date", date)
       c.put("mode", mode)
       c.put("type", "0")
        c.put("note", note)





        var result = write.insert("IncomeExpenseTable", null, c)

        Log.e("TAG", "InsertTableData: " + result)

    }


    fun InsertDataForExpense(amount: String, category: String, mode: String, date: String, note: String) {

        var c = ContentValues()
        c.put("amount", amount)
       c.put("category", category)
        c.put("date", date)
        c.put("mode", mode)
        c.put("note", note)
        c.put("type", "1")

        var write = writableDatabase

        var result = write.insert("IncomeExpenseTable", null, c)

        Log.e("TAG", "InsertDataForExpense: " + result)

    }


    fun DisplayTableData(): ArrayList<ModelClassDisplay> {
        var read = readableDatabase
        var Displaylist = ArrayList<ModelClassDisplay>()
        var query = "select * from IncomeExpenseTable"
        var cursor: Cursor = read.rawQuery(query, null)
        cursor.moveToFirst()


        do {
            var amt = cursor.getString(1)
            var category = cursor.getString(2)
            var date = cursor.getString(3)
            var mode = cursor.getString(4)
            var note = cursor.getString(5)
            var type = cursor.getString(6)
            Log.e("TAG", "DisplayTableData: " + category)
            Displaylist.add(ModelClassDisplay(amt, category, date, mode, note, type))
        } while (cursor.moveToNext())

        return Displaylist

    }


    fun Delete(id: Int) {
        var delete = writableDatabase
        var result = delete.delete("IncomeExpenseTable", "id=?", arrayOf(id.toString()))
        Log.e("TAG", "Delete: " + result)

    }


}

