package com.mihaelmarjanovic.dailylog.model

sealed class DayMood {
    object High : DayMood() {
        override fun toString(): String = "HIGH"
    }
    object Medium : DayMood() {
        override fun toString(): String = "MEDIUM"
    }
    object Low : DayMood(){
        override fun toString(): String = "LOW"
    }
}