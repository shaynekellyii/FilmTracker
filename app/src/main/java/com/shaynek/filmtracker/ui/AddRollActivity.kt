package com.shaynek.filmtracker.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.shaynek.filmtracker.R
import com.shaynek.filmtracker.data.roll.Roll
import com.shaynek.filmtracker.data.roll.RollDao
import com.shaynek.filmtracker.snack
import kotlinx.android.synthetic.main.activity_add_roll.*

class AddRollActivity : AppCompatActivity() {

    companion object {
        val TAG = AddRollActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_roll)

        setSupportActionBar(add_roll_toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = ""
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                android.R.id.home -> {
                    navigateUpTo(Intent(this, MainActivity::class.java))
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }


}
