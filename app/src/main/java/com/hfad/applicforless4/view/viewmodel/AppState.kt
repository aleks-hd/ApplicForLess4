package com.hfad.applicforless4.view.viewmodel

import com.hfad.applicforless4.view.model.Films

sealed class AppState {
    data class Success(val listFilm: Films) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
