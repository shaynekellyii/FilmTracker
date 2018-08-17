package com.shaynek.filmtracker.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shaynek.filmtracker.FilmApp
import com.shaynek.filmtracker.R
import com.shaynek.filmtracker.snack
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MAIN_ACTIVITY"
    private val REQ_CODE = 1111

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_fab.setOnClickListener {
            startActivityForResult(Intent(this, AddRollActivity::class.java), REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQ_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    roll_fab.snack("Added new roll")
                }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
