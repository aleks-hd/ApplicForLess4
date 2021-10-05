package com.hfad.applicforless4.view.repository

import com.hfad.applicforless4.view.model.Films
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmAPI {
    @GET("/3/movie/upcoming")
    fun getListFilm(
        @Query("api_key") token: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<Films>

}