package com.shaynek.filmtracker.data.roll

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RollDao {

    @Query("SELECT * FROM roll")
    fun getAllRolls(): LiveData<List<Roll>>

    @Insert
    fun insert(roll: Roll)

    @Query("DELETE FROM roll")
    fun deleteAllRolls()
}