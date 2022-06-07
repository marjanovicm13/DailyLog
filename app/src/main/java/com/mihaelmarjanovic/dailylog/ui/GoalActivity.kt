package com.mihaelmarjanovic.dailylog.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mihaelmarjanovic.dailylog.databinding.ActivityGoalBinding

class GoalActivity: AppCompatActivity() {

    private lateinit var binding: ActivityGoalBinding

    override fun onCreate(
        savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnAddGoal: Button = binding.btnAddGoal
        btnAddGoal.setOnClickListener(View.OnClickListener {
            val activityIntent = Intent(this, DaylogActivity::class.java)
            startActivity(activityIntent)
        })
    }
}