package com.mihaelmarjanovic.dailylog

import android.content.res.Resources
import android.graphics.Color.green
import android.graphics.Color.red
import com.mihaelmarjanovic.dailylog.model.DayMood

fun Resources.getColorResource(mood: DayMood): Int{
    return when(mood){
        DayMood.High -> R.color.red
        DayMood.Medium -> R.color.yellow
        else -> R.color.green
    }
}