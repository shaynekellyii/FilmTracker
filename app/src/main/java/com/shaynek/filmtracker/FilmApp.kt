package com.shaynek.filmtracker

import android.app.Application
import androidx.room.Room
import com.shaynek.filmtracker.data.FilmDatabase
import com.shaynek.filmtracker.data.roll.RollDao
import com.shaynek.filmtracker.data.roll.RollRepository
import com.shaynek.filmtracker.data.roll.RollViewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

class FilmApp : Application() {

    // Koin module
    val module : Module = applicationContext {
        bean { Room.databaseBuilder(applicationContext, FilmDatabase::class.java, "film-db").build() }
        bean { get<FilmDatabase>().rollDao() }
        bean { RollViewModel(get()) }
        bean { RollRepository(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(module))
    }
}