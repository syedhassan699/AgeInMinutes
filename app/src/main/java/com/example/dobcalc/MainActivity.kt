package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.time.Year
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
   private var tvs : TextView? = null
   private var tvd : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvs = findViewById(R.id.selected)

        val btnd : Button = findViewById(R.id.btndate)
        
        btnd.setOnClickListener{
            btn()
        }

    }

    private fun btn()
    {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month= myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayofmonth ->
                Toast.makeText(this, "Year is $year Month is ${month+1} Day is $dayofmonth", Toast.LENGTH_SHORT).show()

                val selectedDate = "$dayofmonth / ${month+1} / $year"
                tvs?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM//YY", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate.time /60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDate.time/60000

                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                tvd?.text = differenceInMinutes.toString()
                                               },
            year,
            month,
            day
        ).show()
    }



}