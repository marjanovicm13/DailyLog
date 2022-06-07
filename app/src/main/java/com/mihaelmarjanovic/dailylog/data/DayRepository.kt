package com.mihaelmarjanovic.dailylog.data

import com.mihaelmarjanovic.dailylog.model.Day

interface DayRepository {
    fun save(day: Day)
    fun delete(day: Day)
    fun getDayById(id: Long): Day?
    fun getAllDays(): List<Day>
}