package com.example.readingrecorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    companion object {
        val extraDate = "DATE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->

            val gotorecord = Intent(this, RecordActivity::class.java)
            gotorecord.putExtra(extraDate, LocalDate.of(year, month, dayOfMonth))
            startActivity(gotorecord)
        }


    }

}
