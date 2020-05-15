package org.ohmstheresistance.statescognizance.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.home_page_fragment.*

import org.ohmstheresistance.statescognizance.R
import org.ohmstheresistance.statescognizance.databinding.HomePageFragmentBinding

class HomePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<HomePageFragmentBinding>(inflater, R.layout.home_page_fragment, container, false)

        setHomePageImage()

        binding.homePageButton.setOnClickListener { findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToStatesFragment()) }

        return binding.root
    }

    private fun setHomePageImage(){
        val homepageImageHandler = Handler()
        val homepageImageRunnable = Runnable {
            run {

                home_page_imageview.visibility = View.VISIBLE
                home_page_image.visibility = View.GONE
            }
        }
        homepageImageHandler.postDelayed(homepageImageRunnable, 2900)
    }
}
