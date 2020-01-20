package com.primasantosa.android.earthquakereport.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.primasantosa.android.earthquakereport.R
import com.primasantosa.android.earthquakereport.model.Earthquake
import java.text.SimpleDateFormat
import java.util.*

class MainAdapter : ListAdapter<Earthquake, MainAdapter.ViewHolder>(Diffcallback) {

    companion object Diffcallback : DiffUtil.ItemCallback<Earthquake>() {
        override fun areItemsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem.time == newItem.time
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mag: TextView = itemView.findViewById(R.id.list_tv_mag)
        val place: TextView = itemView.findViewById(R.id.list_tv_place)
        val time: TextView = itemView.findViewById(R.id.list_tv_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_earthquake, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val earthquake = getItem(position)

        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

        holder.mag.text = earthquake.mag.toString()
        holder.place.text = earthquake.place
        holder.time.text = formatter.format(earthquake.time)
    }

}