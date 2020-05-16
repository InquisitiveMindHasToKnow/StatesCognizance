package org.ohmstheresistance.statescognizance.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.home_page_fragment.*

import org.ohmstheresistance.statescognizance.R
import org.ohmstheresistance.statescognizance.databinding.HomePageFragmentBinding

class HomePageFragment : Fragment() {

    lateinit var homePageImage: ImageView
    lateinit var homePageImageHandler: Handler
    lateinit var homePageImageRunnable: Runnable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<HomePageFragmentBinding>(inflater, R.layout.home_page_fragment, container, false)

        homePageImage = binding.homePageImageview
        setHomePageImage()

        binding.homePageButton.setOnClickListener { findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToStatesFragment()) }

        return binding.root
    }
    private fun setHomePageImage(){
        homePageImageHandler = Handler()
        homePageImageRunnable = Runnable {
            run {

                homePageImage.visibility = View.VISIBLE
                home_page_image.visibility = View.GONE
            }
        }
        homePageImageHandler.postDelayed(homePageImageRunnable, 2900)
    }

    override fun onDestroy() {
        super.onDestroy()
        homePageImageHandler.removeCallbacksAndMessages(null)
    }
}
