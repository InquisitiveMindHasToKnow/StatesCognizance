package org.ohmstheresistance.statescognizance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import org.ohmstheresistance.statescognizance.R
import org.ohmstheresistance.statescognizance.data.StateInfo
import org.ohmstheresistance.statescognizance.databinding.StatesFragmentBinding
import org.ohmstheresistance.statescognizance.network.StateInfoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StatesFragment : Fragment() {

    val statesList = ArrayList<StateInfo>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val  binding = DataBindingUtil.inflate<StatesFragmentBinding>(inflater, R.layout.states_fragment, container, false)

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

                    response.body()?.forEach { println("STATES: ${it.name}") }

                    response.body()?.let { statesList.addAll(it) }
                    Toast.makeText(context, "IT WORK", Toast.LENGTH_SHORT).show()

                }
                override fun onFailure(call: Call<List<StateInfo>>, t: Throwable) =
                    t.printStackTrace()
            })
    }

}
