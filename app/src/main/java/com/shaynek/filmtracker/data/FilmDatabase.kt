package com.shaynek.filmtracker.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Roll::class), version = 1)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun rollDao(): RollDao
}