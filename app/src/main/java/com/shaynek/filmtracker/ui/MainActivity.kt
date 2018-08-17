package com.shaynek.filmtracker.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.shaynek.filmtracker.FilmApp
import com.shaynek.filmtracker.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MAIN_ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerRollListener()

        roll_fab.setOnClickListener {
//            it.snack("Added new roll", f = {})
            startActivity(Intent(this, AddRollActivity::class.java))
        }
    }

    private fun registerRollListener() {
        FilmApp.database?.rollDao()?.getAllRolls()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe {rollList ->
                    Log.d(TAG, rollList.toString())
                }
    }
}
