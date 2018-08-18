package com.shaynek.filmtracker.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shaynek.filmtracker.R
import com.shaynek.filmtracker.R.id.roll_item_type
import com.shaynek.filmtracker.data.roll.Roll
import kotlinx.android.synthetic.main.roll_recyclerview_item.view.*

class RollAdapter(context: Context) : RecyclerView.Adapter<RollAdapter.RollViewHolder>() {

    private lateinit var cache: List<Roll>
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RollViewHolder
            = RollViewHolder(
            inflater.inflate(R.layout.roll_recyclerview_item, parent, false))

    override fun onBindViewHolder(holder: RollViewHolder, position: Int) {
        if (::cache.isInitialized) {
            val roll = cache.get(position)
            holder.bind(roll.type)
        } else {
            holder.bind("Type not set")
        }
    }

    override fun getItemCount(): Int = if (::cache.isInitialized) cache.size else 0

    fun setCache(rolls: List<Roll>) {
        cache = rolls
        notifyDataSetChanged()
    }

    class RollViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val rollTypeView: TextView = view.roll_item_type

        fun bind(rollType: String) {
            rollTypeView.text = rollType
        }
    }
}