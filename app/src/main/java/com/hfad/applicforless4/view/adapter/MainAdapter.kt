package com.hfad.applicforless4.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.applicforless4.R
import com.hfad.applicforless4.view.model.ResultFilms

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var listFilm: List<ResultFilms> = listOf()

    fun setFilms(date: List<ResultFilms>) {
        listFilm = date
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(filmsItem: ResultFilms) {
            
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val filmsItem = listFilm.get(position)
        holder.bind(filmsItem)
        //поставить случатель
    }


    override fun getItemCount() = listFilm.size

}