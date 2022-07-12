package com.example.rsvpinternshipapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rsvpinternshipapp.R

class CastCrewRVAdapter(var isCast: Boolean) :
    RecyclerView.Adapter<CastCrewRVAdapter.ViewHolder>() {

    val listOfCast = listOf<Pair<String, Int>>(
        "Ryan" to R.drawable.ryan,
        "Morena" to R.drawable.morena,
        "Josh" to R.drawable.josh,
        "Morena" to R.drawable.morena,
        "Josh" to R.drawable.josh,
        "Ryan Gosling" to R.drawable.ryan,
        "Morena" to R.drawable.morena,
        "Josh" to R.drawable.josh,
        "Ryan Gosling" to R.drawable.ryan,
    )
    val listOfCrew = listOf<Pair<String, Int>>(
        "Naika" to R.drawable.naika,
        "Azy" to R.drawable.azy,
        "Steve" to R.drawable.steve,
        "Tylor" to R.drawable.taylor,
        "Morena" to R.drawable.morena,
        "Josh" to R.drawable.josh,
        "Ryan" to R.drawable.ryan,
        "Azy" to R.drawable.azy,
        "Steve" to R.drawable.steve,
        "Tylor" to R.drawable.taylor,
        "Morena" to R.drawable.morena,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val castCrewImage: ImageView = itemView.findViewById(R.id.ivCastCrewMember)
        val castCrewName: TextView = itemView.findViewById(R.id.tvNameOfCastCrewMember)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cast_crew_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (isCast) {
            holder.castCrewImage.setImageResource(listOfCast[position].second)
            holder.castCrewName.text = listOfCast[position].first
        } else {
            holder.castCrewImage.setImageResource(listOfCrew[position].second)
            holder.castCrewName.text = listOfCrew[position].first
        }

    }

    override fun getItemCount(): Int {
        return if (isCast) listOfCast.size else listOfCrew.size
    }
}