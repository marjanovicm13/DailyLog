package com.mihaelmarjanovic.dailylog.ui

import android.app.Application

class DailyLog: Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object{
        lateinit var application: Application
    }
}