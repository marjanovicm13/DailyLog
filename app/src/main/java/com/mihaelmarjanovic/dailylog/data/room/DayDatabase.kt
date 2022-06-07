@file:OptIn(InternalCoroutinesApi::class)

package com.mihaelmarjanovic.dailylog.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mihaelmarjanovic.dailylog.data.DayDAO
import com.mihaelmarjanovic.dailylog.model.Day
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [Day::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(DayConverters::class)
abstract class DayDatabase: RoomDatabase() {
    abstract fun getDayDao(): DayDAO

    companion object {

        private const val databaseName = "notesDb"

        @Volatile
        private var INSTANCE: DayDatabase? = null

        fun getDatabase(context: Context): DayDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): DayDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                DayDatabase::class.java,
                databaseName
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}