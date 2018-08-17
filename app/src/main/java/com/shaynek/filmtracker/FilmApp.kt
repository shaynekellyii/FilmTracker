package com.shaynek.filmtracker

import android.app.Application
import androidx.room.Room
import com.shaynek.filmtracker.data.FilmDatabase

class FilmApp : Application() {

    companion object {
        var database: FilmDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        FilmApp.database =
                Room.databaseBuilder(this, FilmDatabase::class.java, "film-db").build()
    }
}