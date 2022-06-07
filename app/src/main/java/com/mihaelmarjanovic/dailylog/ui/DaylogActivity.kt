package com.mihaelmarjanovic.dailylog.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mihaelmarjanovic.dailylog.databinding.ActivityDaylogBinding

class DaylogActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDaylogBinding

    override fun onCreate(
                          savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaylogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val view: View = inflater.inflate(R.layout.activity_daylog, container, false)

        //Add day button
        val btnAddNewLog: Button = binding.btnAdd
        btnAddNewLog.setOnClickListener(View.OnClickListener {
            val activityIntent = Intent(this, DayActivity::class.java)
            startActivity(activityIntent)
        })

        //Add goals
        val btnAddGoals: Button = binding.btnNewGoal
        btnAddGoals.setOnClickListener(View.OnClickListener {
            val activityIntent = Intent(this, GoalActivity::class.java)
            startActivity(activityIntent)
        })

        //Save day
        val btnSaveDay: Button = binding.btnSaveDay
        btnSaveDay.setOnClickListener(View.OnClickListener {
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        })

        //Goals for the day
        val tvGoals: TextView = binding.tvGoals
    }

    fun addGoals(){

    }
}