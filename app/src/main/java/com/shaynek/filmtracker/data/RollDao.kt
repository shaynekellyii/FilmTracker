package com.shaynek.filmtracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface RollDao {

    @Query("SELECT * FROM roll")
    fun getAllRolls(): LiveData<List<Roll>>

    @Insert
    fun insert(roll: Roll)
}