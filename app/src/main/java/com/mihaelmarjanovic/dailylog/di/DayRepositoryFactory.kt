package com.mihaelmarjanovic.dailylog.di

import com.mihaelmarjanovic.dailylog.ui.DailyLog
import com.mihaelmarjanovic.dailylog.data.DayRepository
import com.mihaelmarjanovic.dailylog.data.DayRepositoryImpl
import com.mihaelmarjanovic.dailylog.data.room.DayDatabase


object DayRepositoryFactory {
    val roomDb = DayDatabase.getDatabase(DailyLog.application)
    val dayRepository: DayRepository = DayRepositoryImpl(roomDb.getDayDao())
}