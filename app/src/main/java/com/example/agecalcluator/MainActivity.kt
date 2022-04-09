package com.example.agecalcluator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {view->
            printAge(view)
        }

    }

    private fun printAge(view:View){

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{
                    view,year,month,day->

                    val selecteddate = "$day/${month+1}/$year"
                    var textview1 = findViewById<TextView>(R.id.textview1)
                    textview1.text=selecteddate

                    var textview2 = findViewById<TextView>(R.id.textview2)

                    val dob = Calendar.getInstance()
                    dob.set(year,month,day)
                    var age = myCalender.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
                    var ageMonth = myCalender.get(Calendar.MONTH) - dob.get(Calendar.MONTH)

                    if(myCalender.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)){
                        age--
                    }
                    textview2.text="You Are $age Year & $ageMonth Month Old"                 },
                year,month,day).show()

    }

}