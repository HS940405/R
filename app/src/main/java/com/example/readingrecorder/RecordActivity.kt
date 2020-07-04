package com.example.readingrecorder

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_record.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RecordActivity : AppCompatActivity() {

    var date: LocalDate? = null
    var pref: SharedPreferences? = null
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        date = intent?.getSerializableExtra(MainActivity.extraDate) as LocalDate?
        loadImp()
        loadName()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)

        //loadImp()
        //loadName()

        plusbutton.setOnClickListener {
            saveName()
            saveImp()
            Toast.makeText(this, "저장되었습니다", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun loadString(name: String): String? {
        if (pref == null) {
            pref = getSharedPreferences("pref", 0)
        }
        return pref!!.getString("${date!!.format(DateTimeFormatter.ISO_LOCAL_DATE)}_$name", "")
    }

    fun saveString(name: String, value: String) {
        if (pref == null) {
            pref = getSharedPreferences("pref", 0)
        }
        pref!!.edit().putString("${date!!.format(DateTimeFormatter.ISO_LOCAL_DATE)}_$name", value)
            .apply()
    }


    fun saveName() {
        saveString("name", booknameedittext.text.toString())
    }

    fun loadName() {
        booknameedittext.setText(loadString("name"))
    }


    fun saveImp() {
        saveString("imp", impressionedittext.text.toString())
    }

    fun loadImp() {
        impressionedittext.setText(loadString("imp"))
    }


}
