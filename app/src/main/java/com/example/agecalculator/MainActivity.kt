package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


        val btndatepicker: Button = findViewById(R.id.btndatepicker)

        btndatepicker.setOnClickListener {
          clickdatepicker()

        }

    }
    private fun clickdatepicker()
    { val tvselecteddate:TextView=findViewById(R.id.tv1)
        val tvselectedate1:TextView=findViewById(R.id.tv2)

        val mycalendar=Calendar.getInstance()
        val year=mycalendar.get(Calendar.YEAR)
        val month=mycalendar.get(Calendar.MONTH)
        val day=mycalendar.get(Calendar.DAY_OF_MONTH)
        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{_,selectedyear,selectedmonth,selecteddayofmonth->
            Toast.makeText(this,"year was$selectedyear and month was${selectedmonth+1} and day was$selecteddayofmonth",Toast.LENGTH_LONG).show()
            val selectedate="$selecteddayofmonth/${selectedmonth+1}/$selectedyear"
            tvselecteddate.text = selectedate
            val stf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val result=stf.parse(selectedate)
            val time=result.time/60000
            val currentdate=stf.parse(stf.format(System.currentTimeMillis()))
            val currentdateinmin=currentdate.time/60000
            val finalresult=currentdateinmin-time
            val finaleresult=(if(finalresult>0){finalresult}
            else{
                "future time not accepted"
            })
            tvselectedate1.text=finaleresult.toString()





        },year,month,day

        )
        dpd.datePicker.maxDate=System.currentTimeMillis()-86400000
        dpd.show()


    }

    }
