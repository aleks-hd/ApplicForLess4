package com.hfad.applicforless4.view.viewNavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.api.load
import com.hfad.applicforless4.databinding.FragmentLikeBinding
import com.hfad.applicforless4.view.model.ResultFilms


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LikeFragment(film: ResultFilms = ResultFilms(0, "", "", "", false)) : Fragment() {
    private var _binding: FragmentLikeBinding? = null
    private val binding get() = _binding!!
    private var param1: String? = null
    private var param2: String? = null
    private var films = film
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLikeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        binding.titleFilmLike.text = films.title
        binding.descriptionFilmLike.text = films.overview
        var url = films.poster_path
        binding.mainBackdrop.load("https://image.tmdb.org/t/p/w200${url}")
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LikeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}