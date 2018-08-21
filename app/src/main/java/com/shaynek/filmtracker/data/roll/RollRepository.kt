package com.shaynek.filmtracker.data.roll

import androidx.lifecycle.LiveData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RollRepository(private val rollDao: RollDao) {

    private var allRolls = rollDao.getAllRolls()
    private var compositeDisposable = CompositeDisposable()

    fun insertRoll(roll: Roll) {
        compositeDisposable.add(
                Single.fromCallable {
                    rollDao.insert(roll)
                }.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
        )
    }

    fun getAllRolls(): LiveData<List<Roll>> = allRolls

    fun deleteAllRolls() {
        compositeDisposable.add(
                Single.fromCallable {
                    rollDao.deleteAllRolls()
                }.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
        )
    }

    fun onCleared() {
        compositeDisposable.dispose()
    }
}