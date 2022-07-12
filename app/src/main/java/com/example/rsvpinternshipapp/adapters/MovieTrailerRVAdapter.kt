package com.example.rsvpinternshipapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.rsvpinternshipapp.R

class MovieTrailerRVAdapter() :
    RecyclerView.Adapter<MovieTrailerRVAdapter.ViewHolder>() {
    val list = listOf(
        R.drawable.thor,
        R.drawable.batman,
        R.drawable.minions,
        R.drawable.forrestgump,
        R.drawable.topgun,
        R.drawable.godfather,
        R.drawable.shawshank,
        R.drawable.thor,
        R.drawable.batman,
        R.drawable.forrestgump,
        R.drawable.topgun,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.ivMovieTrailerPoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_trailor_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieImage.setImageResource(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }
}