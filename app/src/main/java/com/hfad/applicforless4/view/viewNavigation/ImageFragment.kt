package com.hfad.applicforless4.view.viewNavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.applicforless4.R
import com.hfad.applicforless4.databinding.FragmentImageBinding
import com.hfad.applicforless4.databinding.FragmentMainBinding
import com.hfad.applicforless4.view.adapter.MainAdapter
import com.hfad.applicforless4.view.model.ResultFilms
import com.hfad.applicforless4.view.viewmodel.AppState
import com.hfad.applicforless4.view.viewmodel.MainViewModel


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ImageFragment : Fragment() {
    var listFilm: List<ResultFilms> = listOf()
    private val adapter = MainAdapter()
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!
    private val viewModel = MainViewModel()
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
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { render(it) })
        viewModel.getFilmFromServer()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter.setOnClickListenerCustome(object : MainAdapter.OnItemClick{
            override fun fordardClick(film: ResultFilms) {
                Log.i("AAAAAA", "${film.title}")
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.addToBackStack(null)
                        ?.replace(R.id.fragment_new_container, LikeFragment(film))
                        ?.commit()
            }

        })
    }

    private fun render(it: AppState?) {
        when (it) {
            is AppState.Success -> {
                listFilm = it.listFilm.results
                setData(listFilm)
              var size = listFilm.size -1
             for (i in 0..size){
                    var abultTest = listFilm.get(i).adult
                 var sad = listFilm.get(i).title
                    Log.i("ABULT", "$abultTest + $sad")
                }
            }

        }
    }

    private fun setData(listFilm: List<ResultFilms>) {
        adapter.setFilms(listFilm)
    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}