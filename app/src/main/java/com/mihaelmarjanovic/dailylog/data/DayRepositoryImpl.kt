package com.mihaelmarjanovic.dailylog.data

import com.mihaelmarjanovic.dailylog.model.Day

class DayRepositoryImpl(val dayDao: DayDAO): DayRepository {
    override fun save(day: Day) = dayDao.save(day)
    override fun delete(day: Day) = dayDao.delete(day)
    override fun getDayById(id: Long): Day? = dayDao.getDayById(id)
    override fun getAllDays(): List<Day> = dayDao.getAllDays()
}