package com.example.rsvpinternshipapp.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rsvpinternshipapp.R

class CategoryOfMovieRVAdapter() : RecyclerView.Adapter<CategoryOfMovieRVAdapter.ViewHolder>() {


    val list = listOf<Pair<String, Int>>(
        "Comedy" to Color.BLUE,
        "Action" to Color.RED,
        "Adventure" to Color.MAGENTA,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTv: TextView = itemView.findViewById(R.id.tvCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_of_movie_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryTv.text = list[position].first
        holder.categoryTv.setBackgroundColor(list[position].second)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}