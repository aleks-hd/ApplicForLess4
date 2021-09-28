package com.hfad.applicforless4.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.hfad.applicforless4.R
import com.hfad.applicforless4.view.model.ResultFilms

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    lateinit var customelick: OnItemClick
    private var listFilm: List<ResultFilms> = listOf()

    fun setFilms(date: List<ResultFilms>) {
        listFilm = date
        notifyDataSetChanged()
    }

    fun setOnClickListenerCustome(listener: OnItemClick) {
        customelick = listener
    }

    interface OnItemClick {
        fun fordardClick(film: ResultFilms)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val filmsItem = listFilm.get(position)
        holder.bind(filmsItem)
    }

    override fun getItemCount() = listFilm.size
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(filmsItem: ResultFilms) {
            itemView.findViewById<TextView>(R.id.title_film).text = filmsItem.title
            itemView.findViewById<CardView>(R.id.container_card_view).setOnClickListener {
                customelick.fordardClick(filmsItem)
            }
            var pictures = filmsItem.poster_path.toString()
            itemView.findViewById<AppCompatImageView>(R.id.card_view)
                .load("https://image.tmdb.org/t/p/w200${pictures}")
        }


    }

}

