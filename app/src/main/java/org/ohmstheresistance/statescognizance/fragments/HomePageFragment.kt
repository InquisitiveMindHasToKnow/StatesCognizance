package org.ohmstheresistance.statescognizance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.home_page_fragment.*
import org.ohmstheresistance.statescognizance.R
import org.ohmstheresistance.statescognizance.data.StateInfo
import org.ohmstheresistance.statescognizance.databinding.HomePageFragmentBinding
import org.ohmstheresistance.statescognizance.network.StateInfoService
import org.ohmstheresistance.statescognizance.rv.FlagsAdapter
import org.ohmstheresistance.statescognizance.rv.StatesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<HomePageFragmentBinding>(inflater, R.layout.home_page_fragment, container, false)
        binding.homePageButton.setOnClickListener { findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToStatesFragment()) }
        getInfo()

        return binding.root
    }

    private fun getInfo() {

        val service = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StateInfoService::class.java)

        service.retrieveStatesInformation("InquisitiveMindHasToKnow")
            .enqueue(object : Callback<List<StateInfo>> {
                override fun onResponse(call: Call<List<StateInfo>>, response: Response<List<StateInfo>>) {

                    val stateFlagsList = ArrayList<StateInfo>()
                    response.body()?.forEach { println("STATES: ${it.name}") }
                    response.body()?.let { stateFlagsList.addAll(it) }

                    val flagsAdapter = FlagsAdapter(stateFlagsList)
                    state_flags_recyclerview.layoutManager = GridLayoutManager(context,5, GridLayoutManager.VERTICAL, false)
                    state_flags_recyclerview.adapter = flagsAdapter

                }
                override fun onFailure(call: Call<List<StateInfo>>, t: Throwable) =
                    t.printStackTrace()
            })

}
}
