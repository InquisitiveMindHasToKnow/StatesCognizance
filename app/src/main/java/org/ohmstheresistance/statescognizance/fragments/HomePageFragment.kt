package org.ohmstheresistance.statescognizance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import org.ohmstheresistance.statescognizance.R
import org.ohmstheresistance.statescognizance.databinding.HomePageFragmentBinding

class HomePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<HomePageFragmentBinding>(inflater, R.layout.home_page_fragment, container, false)

        binding.homePageButton.setOnClickListener { findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToStatesFragment()) }

        return binding.root
    }

}
