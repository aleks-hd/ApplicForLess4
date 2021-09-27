package com.hfad.applicforless4.view.model

data class Films(val results: List<ResultFilms>)

data class ResultFilms(
    val id: Int?,
    val title: String?,
    val poster_path: String?,
    val overview: String?,
    val adult: Boolean?
)
