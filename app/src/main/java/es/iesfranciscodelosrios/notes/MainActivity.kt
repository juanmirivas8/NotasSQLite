package es.iesfranciscodelosrios.notes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.set

class MainActivity : AppCompatActivity() {
    private lateinit var context : Context
    private lateinit var db : DataBaseHelper
    private lateinit var btnAdd:Button
    private lateinit var btnView:Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        db = DataBaseHelper(this)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)
        editText = findViewById(R.id.editText)

        btnAdd.setOnClickListener{
            val text = editText.text.toString()
            if(editText.length() > 0){
                db.addData(text)
                editText.text.clear()
                Toast.makeText(context,"Post inserted correctly",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"Put something in the text field",Toast.LENGTH_LONG).show()
            }
        }

        btnView.setOnClickListener{
           val nInt = Intent(context,ViewListContents::class.java)
            startActivity(nInt)
        }
    }
}