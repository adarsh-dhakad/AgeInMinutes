package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker = findViewById<Button>(R.id.buttonDatePicker)

        buttonDatePicker.setOnClickListener {view ->
            //Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
        clickDatePicker(view)

        }
    }
 fun clickDatePicker(view: View){
     val myCalender = Calendar.getInstance()
     val year = myCalender.get(Calendar.YEAR)
     val month = myCalender.get(Calendar.MONTH)
     val day = myCalender.get(Calendar.DAY_OF_MONTH)
  val dpd =   DatePickerDialog(this,
             DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
          val t = findViewById<TextView>(R.id.tvSelectedDate)
        val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                 t.setText(selectedDate)
          val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
          val theDate = sdf.parse(selectedDate)
     //     val dateInSecond = theDate!!.time / 1000
          val dateInMinutes = theDate!!.time / 60000
     //     val dateInDays = theDate!!.time / 86400000
        val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
        val currentDateInMinutes = currentDate!!.time / 60000
      //  val currentDateInDays = currentDate!!.time /86400000
        val differenceInMinutes = currentDateInMinutes - dateInMinutes
      //  val differenceInDays = currentDateInDays - dateInDays
       val textAgeInMinutes = findViewById<TextView>(R.id.tvSelectedDateInMinutes)
        textAgeInMinutes.text = "$differenceInMinutes"
     } ,year,month,day)
     dpd.datePicker.setMaxDate(Date().time - 86400000)
     dpd.show()
 }
}


