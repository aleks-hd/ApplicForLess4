package com.hfad.applicforless4.view.repository

import com.google.gson.GsonBuilder
import com.hfad.applicforless4.view.model.Films
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    private val filmsApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        )
        .build().create(FilmAPI::class.java)

    fun getFilmDetail(callback: Callback<Films>) {
        filmsApi.getListFilm("26c76063ddc0678e825b62a173a38f08", "en-US", 1)
            .enqueue(callback)
    }

}