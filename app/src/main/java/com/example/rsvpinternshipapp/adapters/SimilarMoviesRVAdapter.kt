package com.example.rsvpinternshipapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.rsvpinternshipapp.R

class SimilarMoviesRVAdapter() :
    RecyclerView.Adapter<SimilarMoviesRVAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.ivSimilarMoviesPoster)
    }

    val list = listOf(
        R.drawable.forrestgump,
        R.drawable.topgun,
        R.drawable.godfather,
        R.drawable.shawshank,
        R.drawable.thor,
        R.drawable.minions,
        R.drawable.batman,
        R.drawable.forrestgump,

        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.similar_movies_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieImage.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}