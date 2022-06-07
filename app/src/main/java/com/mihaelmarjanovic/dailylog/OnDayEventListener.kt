package com.mihaelmarjanovic.dailylog

import com.mihaelmarjanovic.dailylog.model.Day

interface OnDayEventListener {
    fun onDaySelected(id: Long?)
    fun onDayLongPress(day: Day?): Boolean
}