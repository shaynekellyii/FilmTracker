package com.shaynek.filmtracker.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideAppContext() = context

    @Provides
    @Singleton
    fun provideFilmDb(context: Context): FilmDatabase =
            Room.databaseBuilder(context, FilmDatabase::class.java, "film-db").build()

    @Provides
    @Singleton
    fun provideRollDao(db: FilmDatabase) = db.rollDao()

    @Provides
    @Singleton
    fun provideRollRepository() = RollRepository()
}