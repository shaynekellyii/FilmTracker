package com.shaynek.filmtracker.data.roll

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class RollViewModel(repository: RollRepository) : ViewModel() {

    private val rollRepository: RollRepository = repository
    private var allRolls: LiveData<List<Roll>> = rollRepository.getAllRolls()

    fun getAllRolls(): LiveData<List<Roll>> = allRolls

    fun insertRoll(roll: Roll) = rollRepository.insertRoll(roll)
}