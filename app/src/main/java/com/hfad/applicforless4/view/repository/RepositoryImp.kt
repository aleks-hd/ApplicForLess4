package com.hfad.applicforless4.view.repository

import com.hfad.applicforless4.view.model.Films
import retrofit2.Callback

class RepositoryImp(private val remoteDataSource: RemoteDataSource) : DetailRepository {
    override fun getDetailFromServer(callback: Callback<Films>) {
        remoteDataSource.getFilmDetail(callback)
    }
}