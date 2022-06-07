package com.mihaelmarjanovic.dailylog.data.room

import androidx.room.TypeConverter
import com.mihaelmarjanovic.dailylog.model.Day
import com.mihaelmarjanovic.dailylog.model.DayMood
import java.util.*

class DayConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toString(priority: DayMood): String{
        return priority.toString()
    }

    @TypeConverter
    fun fromString(priority: String): DayMood{
        return when(priority){
            DayMood.High.toString() -> DayMood.High
            DayMood.Medium.toString() -> DayMood.Medium
            DayMood.Low.toString() -> DayMood.Low
            else -> DayMood.Low
        }
    }
}