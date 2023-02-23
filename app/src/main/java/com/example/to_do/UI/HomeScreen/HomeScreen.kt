
package com.example.to_do.UI.HomeScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.to_do.R

class HomeScreen : Fragment() {

    companion object {
        fun newInstance() = HomeScreen()
    }

    private lateinit var viewModel: HomeScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}