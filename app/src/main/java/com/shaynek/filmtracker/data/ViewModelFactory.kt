package com.shaynek.filmtracker.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val dao: RollDao): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RollViewModel::class.java)) {
            return RollViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}