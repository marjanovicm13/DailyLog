package com.mihaelmarjanovic.dailylog.data.memory_db
import kotlin.random.Random
import com.mihaelmarjanovic.dailylog.data.DayDAO
import com.mihaelmarjanovic.dailylog.model.Day
import com.mihaelmarjanovic.dailylog.model.DayMood
import java.util.*



class InMemoryDB: DayDAO {
    private val days = mutableListOf<Day>()
        //mutableListOf<Day>()

    init {
        val moods =
            arrayOf(DayMood.High, DayMood.Medium, DayMood.Low)
        for (i in 1..30) {
            save(
                Day(
                    i.toLong(),
                    "Task_$i",
                    "Please, do task.",
                    moods[Random.nextInt(3)],
                    Date()
                )
            )
        }
    }

    override fun save(day: Day) {
        days.add(day)
    }

    override fun delete(day: Day) {
        days.remove(day)
    }

    override fun getDayById(id: Long): Day? {
        return days.firstOrNull { it.id == id }
    }

    override fun getAllDays(): List<Day> {
        return days
    }
}