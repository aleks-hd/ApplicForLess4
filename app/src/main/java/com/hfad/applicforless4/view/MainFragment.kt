package com.hfad.applicforless4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.applicforless4.R
import com.hfad.applicforless4.databinding.FragmentMainBinding
import com.hfad.applicforless4.view.viewNavigation.ImageFragment
import com.hfad.applicforless4.view.viewNavigation.LikeFragment
import com.hfad.applicforless4.view.viewNavigation.SettingsFragment


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.randome_image -> {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.addToBackStack(null)
                        ?.replace(R.id.fragment_new_container, ImageFragment())
                        ?.commit()
                    true
                }
                R.id.favorite_image -> {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.addToBackStack(null)
                        ?.replace(R.id.fragment_new_container, LikeFragment())
                        ?.commit()
                    true
                }
                R.id.setting_app -> {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.addToBackStack(null)
                        ?.replace(R.id.fragment_new_container, SettingsFragment())
                        ?.commit()
                    true
                }
                else -> false
            }
        }
        binding.bottomNavigationView.selectedItemId = R.id.setting_app

    }

   fun initFragment(nameFragment :String){

   }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}