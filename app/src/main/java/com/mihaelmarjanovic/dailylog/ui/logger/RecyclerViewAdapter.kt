package com.mihaelmarjanovic.dailylog.ui.logger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mihaelmarjanovic.dailylog.getColorResource
import androidx.recyclerview.widget.RecyclerView
import com.mihaelmarjanovic.dailylog.OnDayEventListener
import com.mihaelmarjanovic.dailylog.R
import com.mihaelmarjanovic.dailylog.databinding.DayLogBinding
import com.mihaelmarjanovic.dailylog.model.Day

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val days = mutableListOf<Day>()
    var onDaySelectedListener: OnDayEventListener? = null

    fun setDays(days: List<Day>) {
        this.days.clear()
        this.days.addAll(days)
        this.notifyDataSetChanged()
    }
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.day_log, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val DayViewModel = days[position]
        //holder.bind(DayViewModel)
        // sets the text to the textview from our itemHolder class
        holder.bind(DayViewModel)
        onDaySelectedListener?.let { listener ->
            holder.itemView.setOnClickListener { listener.onDaySelected(DayViewModel.id) }
            holder.itemView.setOnLongClickListener { listener.onDayLongPress(DayViewModel) }
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return days.count()
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        //val textView: TextView = itemView.findViewById(R.id.textView)
        fun bind(day: Day) {
            val binding = DayLogBinding.bind(itemView)
            binding.itemDayTitle.text = day.title
            binding.itemDayContent.text = day.content
            binding.itemDayPriority.setBackgroundResource(
                binding.itemDayPriority.context.resources.getColorResource(day.mood)
            )
        }
    }
}