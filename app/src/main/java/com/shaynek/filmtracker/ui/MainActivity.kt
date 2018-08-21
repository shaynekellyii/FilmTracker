package com.shaynek.filmtracker.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shaynek.filmtracker.R
import com.shaynek.filmtracker.data.roll.Roll
import com.shaynek.filmtracker.data.roll.RollViewModel
import com.shaynek.filmtracker.snack
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val REQ_CODE = 1111

    private val rollViewModel: RollViewModel by inject()
    private lateinit var adapter: RollAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(main_toolbar)
        supportActionBar?.title = ""

        adapter = RollAdapter(this)
        roll_recyclerview.adapter = adapter
        roll_recyclerview.layoutManager = LinearLayoutManager(this)

        rollViewModel.getAllRolls().observe(this, Observer {
            adapter.setCache(it)
        })

        roll_fab.setOnClickListener {
            startActivityForResult(Intent(this, AddRollActivity::class.java), REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQ_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    val roll = data?.getParcelableExtra<Roll>(AddRollActivity.TAG)
                    roll?.let {
                        rollViewModel.insertRoll(it)
                        roll_fab.snack("Added new roll")
                    } ?: roll_fab.snack("Failed to add new roll")
                }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_clear_data -> rollViewModel.deleteAllRolls()
        }
        return super.onOptionsItemSelected(item)
    }
}
