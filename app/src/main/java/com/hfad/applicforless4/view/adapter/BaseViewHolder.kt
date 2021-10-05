package com.hfad.applicforless4.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hfad.applicforless4.view.model.Films

abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(pair: Pair<Films,Boolean>)
}