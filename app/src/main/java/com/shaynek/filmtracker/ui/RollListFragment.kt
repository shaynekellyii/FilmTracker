package com.shaynek.filmtracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shaynek.filmtracker.R
import com.shaynek.filmtracker.data.roll.RollViewModel
import kotlinx.android.synthetic.main.fragment_roll_list.*
import org.koin.android.ext.android.inject

class RollListFragment : Fragment() {

    companion object {
        fun newInstance(): RollListFragment = RollListFragment()
    }

    private val rollViewModel: RollViewModel by inject()
    private lateinit var adapter: RollAdapter

    fun RollListFragment() {
        // Required empty constructor.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_roll_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = RollAdapter(roll_recyclerview.context)
        roll_recyclerview.adapter = adapter
        roll_recyclerview.layoutManager = LinearLayoutManager(roll_recyclerview.context)

        rollViewModel.getAllRolls().observe(this, Observer {
            adapter.setCache(it)
        })
    }
}
