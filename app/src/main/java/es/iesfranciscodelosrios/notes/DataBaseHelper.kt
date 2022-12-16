package es.iesfranciscodelosrios.notes

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        val DATABASE_NAME = "notes.db"
        val DATABASE_VERSION = 1
        val TABLE_NAME = "notes"
        val COL_ID = "id"
        val COL_CONTENT = "content"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME (id INTEGER PRIMARY KEY AUTOINCREMENT,content TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addData(content: String){
        val db = this.writableDatabase
        val contentVals = ContentValues()
        contentVals.put(COL_CONTENT, content)
        db.insert(TABLE_NAME, null, contentVals)
    }

    fun getList():Cursor{
        val db = this.writableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
}