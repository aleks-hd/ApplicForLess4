package com.hfad.applicforless4.view.model

data class Films(val results: List<ResultFilms>)

data class ResultFilms(
    val id: Int?=0,
    var title: String?="",
    var poster_path: String?="",
    val overview: String?="",
    var adult: Boolean?=true
)
