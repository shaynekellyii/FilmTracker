package com.shaynek.filmtracker.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shaynek.filmtracker.R
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
            holder.bind(cache.get(position))
        }
    }

    override fun getItemCount(): Int = if (::cache.isInitialized) cache.size else 0

    fun setCache(rolls: List<Roll>) {
        cache = rolls
        notifyDataSetChanged()
    }

    class RollViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val rollNameView: TextView = view.roll_item_name
        private val rollDetailsView: TextView = view.roll_item_details

        fun bind(roll: Roll) {
            val context = rollNameView.context
            rollNameView.text = context.getString(R.string.roll_item_title, roll.brand, roll.type)
            rollDetailsView.text = context.getString(R.string.roll_item_details,
                    if (roll.colour) context.getString(R.string.colour) else context.getString(R.string.black_white),
                    roll.iso, roll.exp)
        }
    }
}