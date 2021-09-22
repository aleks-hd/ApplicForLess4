package com.hfad.applicforless4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.applicforless4.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, MainFragment.newInstance())
            .commit()
    }
}