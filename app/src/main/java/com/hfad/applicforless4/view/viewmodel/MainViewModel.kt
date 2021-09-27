package com.hfad.applicforless4.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.applicforless4.view.model.Films
import com.hfad.applicforless4.view.repository.RemoteDataSource
import com.hfad.applicforless4.view.repository.RepositoryImp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val detailsLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val detailRepositoryImp: RepositoryImp = RepositoryImp(RemoteDataSource())
) : ViewModel() {

    fun getLiveData() = detailsLiveData

    fun getFilmFromServer() {
        detailsLiveData.value = AppState.Loading
        detailRepositoryImp.getDetailFromServer(callback)
    }

    private val callback = object : Callback<Films> {
        override fun onResponse(call: Call<Films>, response: Response<Films>) {
            val serverResponse: Films? = response.body()
            detailsLiveData.postValue(
                if (response.isSuccessful && serverResponse != null) {
                    checkResponse(serverResponse)
                } else {
                    AppState.Error(Throwable("Error server"))
                }
            )
        }

        override fun onFailure(call: Call<Films>, t: Throwable) {
            detailsLiveData.postValue(
                AppState.Error(
                    Throwable(
                        t.message ?: "Ошибка запроса на сервер"
                    )
                )
            )
        }

    }

    private fun checkResponse(serverResponse: Films?): AppState {
        val film = serverResponse?.results
        val rew = film?.get(0)

        return if (rew?.id == null) {
            AppState.Error(Throwable("Не полные данные"))
        } else
            AppState.Success(serverResponse)
    }

}