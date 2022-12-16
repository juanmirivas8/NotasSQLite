package es.iesfranciscodelosrios.notes

import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.widget.ArrayAdapter

import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ViewListContents : AppCompatActivity(){

    private lateinit var context : Context
    lateinit var db : DataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewlistscontents_layout)
        db = DataBaseHelper(this)
        context = this

        val listView = findViewById<ListView>(R.id.listView)

        db = DataBaseHelper(this)

        val theList = ArrayList<String>()
        val data : Cursor = db.getList()

        if(data.count == 0) Toast.makeText(context,"No notes", Toast.LENGTH_LONG).show()
        else while (data.moveToNext()){
            theList.add(data.getString(1))
            val ltAdapter = ArrayAdapter(context, android.R.layout.simple_list_item_1,theList)
            listView.adapter = ltAdapter

        }

    }
}