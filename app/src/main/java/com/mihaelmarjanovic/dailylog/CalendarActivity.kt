/*
package com.mihaelmarjanovic.dailylog

import android.R
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CalendarActivity: AppCompatActivity() {
    var calendar: CalendarView? = null
    var dateView: TextView? = null
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_calender)
        calendar = findViewById(R.id.calender)
        dateView = findViewById(R.id.dateView)
        calendar!!.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val Date = dayOfMonth.toString() + "-" + (month + 1) + "-" + year
            dateView!!.text = Date
        }
    }
}*/
