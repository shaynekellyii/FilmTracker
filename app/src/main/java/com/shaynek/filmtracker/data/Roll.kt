package com.shaynek.filmtracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roll")
data class Roll(
        @PrimaryKey(autoGenerate = true)
        var uid: Long = 0,
        var brand: String = "",
        var type: String = "",
        var iso: String = "",
        var colour: Boolean = false
)