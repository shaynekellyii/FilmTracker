package com.shaynek.filmtracker.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.shaynek.filmtracker.FilmApp
import com.shaynek.filmtracker.R
import com.shaynek.filmtracker.data.Roll
import com.shaynek.filmtracker.data.RollDao
import com.shaynek.filmtracker.snack
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_roll.*
import javax.inject.Inject

class AddRollActivity : AppCompatActivity() {

    @Inject
    lateinit var dao: RollDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_roll)

        setSupportActionBar(add_roll_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        add_bw_radio.isChecked = true
        add_roll_fab.setOnClickListener {
            if (validateData()) {
                addRoll()
                setResult(Activity.RESULT_OK, Intent())
                finish()
            } else {
                it.snack("Please fill out all of the information")
            }
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

    private fun validateData(): Boolean {
        return add_brand.text != null && !add_brand.text.isEmpty()
                && add_type.text != null && !add_type.text.isEmpty()
                && add_iso.text != null && !add_iso.text.isEmpty()
    }

    private fun addRoll() {
        val roll = Roll(0, add_brand.text.toString(), add_type.text.toString(),
                add_iso.toString(), add_colour_radio.isChecked)
    }
}