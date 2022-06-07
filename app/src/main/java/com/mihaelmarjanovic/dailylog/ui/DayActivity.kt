package com.mihaelmarjanovic.dailylog.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mihaelmarjanovic.dailylog.databinding.ActivityDayBinding
import com.mihaelmarjanovic.dailylog.di.DayRepositoryFactory
import com.mihaelmarjanovic.dailylog.model.Day
import com.mihaelmarjanovic.dailylog.model.DayMood
import java.text.SimpleDateFormat
import java.util.*

class DayActivity: AppCompatActivity() {

    private val dayRepository = DayRepositoryFactory.dayRepository
    private lateinit var binding: ActivityDayBinding

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        binding = ActivityDayBinding.inflate(layoutInflater)
        binding.btnAdd.setOnClickListener{saveDay()}
        setContentView(binding.root)
    }

    private fun saveDay(){
        val c: Date = Calendar.getInstance().getTime()
        val df = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
        val formattedDate = df.format(c)
        val diary = binding.etDay.text.toString()
        val dateAdded = formattedDate

        dayRepository.save(Day(0, "Title", diary, DayMood.High, c))

        val activityIntent = Intent(this, DaylogActivity::class.java)
        startActivity(activityIntent)

    }

    companion object {
        val Tag = "NewTask"

        fun create(): Activity {
            return DayActivity()
        }
    }
}