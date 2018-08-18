package com.shaynek.filmtracker.data.roll

import androidx.lifecycle.LiveData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RollRepository(private val rollDao: RollDao) {

    private var allRolls = rollDao.getAllRolls()

    fun insertRoll(roll: Roll) {
        Single.fromCallable {
            rollDao.insert(roll)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    fun getAllRolls(): LiveData<List<Roll>> = allRolls
}