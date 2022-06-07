package com.mihaelmarjanovic.dailylog.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "days")
data class Day(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "title") // Optional!
    val title: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "mood")
    val mood: DayMood,
    @ColumnInfo(name = "dateAdded")
    val dateAdded: Date
) {

}