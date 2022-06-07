package com.mihaelmarjanovic.dailylog.data

import androidx.room.*
import com.mihaelmarjanovic.dailylog.model.Day

@Dao
interface DayDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(day: Day)

    @Delete
    fun delete(day: Day)

    @Query("SELECT * FROM days WHERE id =:id")
    fun getDayById(id: Long): Day?

    @Query("SELECT * FROM days")
    fun getAllDays(): List<Day>
}