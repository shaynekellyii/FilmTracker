package com.shaynek.filmtracker.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shaynek.filmtracker.R
import com.shaynek.filmtracker.data.roll.Roll
import com.shaynek.filmtracker.snack
import kotlinx.android.synthetic.main.activity_add_roll.*
import kotlinx.android.synthetic.main.fragment_add_roll.*

class AddRollFragment : Fragment() {

    companion object {
        fun newInstance(): AddRollFragment = AddRollFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_roll, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        add_bw_radio.isChecked = true
        add_roll_fab.setOnClickListener {
            if (validateData()) {
                val intent = Intent()
                intent.putExtra(AddRollActivity.TAG, Roll(0, add_brand.text.toString(), add_type.text.toString(),
                        add_iso.text.toString(), add_exp.text.toString(), add_colour_radio.isChecked))
                // TODO: Save result with shared ViewModel
//                setResult(Activity.RESULT_OK, intent)
//                finish()
            } else {
                it.snack("Please fill out all information")
            }
        }
    }

    private fun validateData(): Boolean {
        return add_brand.text != null && !add_brand.text.toString().isEmpty()
                && add_type.text != null && !add_type.text.toString().isEmpty()
                && add_iso.text != null && !add_iso.text.toString().isEmpty()
    }
}