package com.hfad.applicforless4.view.repository

import com.hfad.applicforless4.view.model.Films


interface DetailRepository {
    fun getDetailFromServer(callback: retrofit2.Callback<Films>)
}