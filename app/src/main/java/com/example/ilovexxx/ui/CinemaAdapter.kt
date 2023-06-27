package com.example.ilovexxx.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ilovexxx.R
import com.example.ilovexxx.model.Film

class CinemaAdapter(val films: ArrayList<Film>, val context: Context) : RecyclerView.Adapter<CinemaAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageCinema)
        val textName: TextView = itemView.findViewById(R.id.textCinema)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cinema_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val oneCinema = films[position]
        holder.apply {
            textName.text = oneCinema.nameRu

            Glide.with(context)
                 .load(oneCinema.posterUrl)
                 .into(image)
        }
    }

    override fun getItemCount(): Int {
        return films.size
    }
}