package com.shaynek.filmtracker.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
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

        add_bw_radio.isChecked = true
        add_roll_fab.setOnClickListener {
            if (validateData()) {
                val intent = Intent()
                intent.putExtra(TAG, Roll(0, add_brand.text.toString(), add_type.text.toString(),
                        add_iso.text.toString(), add_colour_radio.isChecked))
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                it.snack("Please fill out all information")
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
}
