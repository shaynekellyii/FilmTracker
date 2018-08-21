package com.shaynek.filmtracker.data.roll

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "roll")
data class Roll(
        @PrimaryKey(autoGenerate = true)
        var uid: Long = 0,
        var brand: String = "",
        var type: String = "",
        var iso: String = "",
        var exp: String = "",
        var colour: Boolean = false) : Parcelable
