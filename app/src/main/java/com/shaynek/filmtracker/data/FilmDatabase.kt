package com.shaynek.filmtracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shaynek.filmtracker.data.roll.Roll
import com.shaynek.filmtracker.data.roll.RollDao

@Database(entities = arrayOf(Roll::class), version = 1)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun rollDao(): RollDao
}