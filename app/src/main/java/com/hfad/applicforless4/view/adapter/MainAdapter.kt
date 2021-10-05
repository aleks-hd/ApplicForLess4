package com.hfad.applicforless4.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.hfad.applicforless4.R
import com.hfad.applicforless4.view.model.ResultFilms

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var customelick: OnItemClick
    private var listFilm: List<ResultFilms> = listOf()
    private var listFilmTransformer: MutableList<ResultFilms> = mutableListOf()
    fun setFilms(date: List<ResultFilms>) {
        listFilmTransformer = date.toMutableList()
        var sd = listFilmTransformer.get(0)
        sd.adult = true
        sd.title = "Заголовок"
        sd.poster_path = ""
        listFilm = listFilmTransformer.toList()

        notifyDataSetChanged()
    }

    fun setOnClickListenerCustome(listener: OnItemClick) {
        customelick = listener
    }

    interface OnItemClick {
        fun fordardClick(film: ResultFilms)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType != TYPE_ABULT) {
            ViewHolder(
                inflater.inflate(
                    R.layout.item, parent,
                    false
                ) as View
            )
        } else {
            AbultViewHolder(
                inflater.inflate(
                    R.layout.item_not_abult, parent,
                    false
                ) as View
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_ABULT) {
            holder as AbultViewHolder
            holder.bind(listFilm.get(position))
        } else {
            holder as ViewHolder
            holder.bind(listFilm.get(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (listFilm.get(position).adult == false) {
            TYPE_NOT_ABULT
        } else {
            TYPE_ABULT
        }
    }

    override fun getItemCount() = listFilm.size

    inner class AbultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(filmsItem: ResultFilms) {
            initListener(itemView, filmsItem)

        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(filmsItem: ResultFilms) {
            itemView.findViewById<AppCompatImageView>(R.id.image_abult)
                .setImageResource(R.drawable.abultimage)
            initListener(itemView, filmsItem)
            itemView.findViewById<AppCompatImageView>(R.id.image_up)
                .setOnClickListener { moveUp(filmsItem) }
            itemView.findViewById<AppCompatImageView>(R.id.image_down)
                .setOnClickListener { moveDown(filmsItem) }

        }

        //Перемещение item's
        fun moveUp(filmsItem: ResultFilms) {

            layoutPosition.takeIf { it > 1 }?.also { position ->
                listFilm.toMutableList().add(position - 1, filmsItem)
            }
            notifyItemMoved(position, position - 1)
        }

        fun moveDown(filmsItem: ResultFilms) {
            layoutPosition.takeIf { it > 1 }?.also { position ->
                listFilm.toMutableList().add(position + 1, filmsItem)
            }
            notifyItemMoved(position, position + 1)
        }

    }


    fun initListener(itemView: View, filmsItem: ResultFilms) {
        itemView.findViewById<TextView>(R.id.title_film).text = filmsItem.title
        itemView.findViewById<AppCompatImageView>(R.id.card_view).setOnClickListener {
            customelick.fordardClick(filmsItem)
        }
        var pictures = filmsItem.poster_path.toString()
        itemView.findViewById<AppCompatImageView>(R.id.card_view)
            .load("https://image.tmdb.org/t/p/w200${pictures}")

    }



    companion object {
        private const val TYPE_ABULT = 0
        private const val TYPE_NOT_ABULT = 1
    }



}


