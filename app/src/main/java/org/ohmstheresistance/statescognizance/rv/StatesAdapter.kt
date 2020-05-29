package org.ohmstheresistance.statescognizance.rv

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.state_itemview.view.*
import org.ohmstheresistance.statescognizance.R
import org.ohmstheresistance.statescognizance.data.StateInfo
import org.ohmstheresistance.statescognizance.fragments.StatesFragmentDirections

class StatesAdapter(private val stateList: ArrayList<StateInfo>) :
    RecyclerView.Adapter<StatesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.state_itemview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(stateList[position])
    }

    override fun getItemCount(): Int {
        return stateList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bindItems(stateInfo: StateInfo) {

            val stateName = stateInfo.name
            val stateNameAbbreviation = stateInfo.abbreviation
            val stateFlag = stateInfo.flag
            val admittedToStatehood = stateInfo.admissionToStatehood
            val stateCapital = stateInfo.capital
            val stateNickname = stateInfo.nickname
            val statePopulation = stateInfo.population
            val stateAreaCodes = stateInfo.areaCodes
            val borderStates = stateInfo.borderStates
            val area = stateInfo.area
            val stateLocation = stateInfo.location
            val stateFlower = stateInfo.stateFlower
            val stateTree = stateInfo.stateTree
            val highestPoint = stateInfo.highestPoint
            val lowestPoint = stateInfo.lowestPoint
            val stateBird = stateInfo.stateBird
            val totalCounties = stateInfo.totalCounties

            itemView.state_name_and_abbreviation_textview.text =
                "$stateName, $stateNameAbbreviation"

            Glide.with(itemView.context)
                .load(stateFlag)
                .into(itemView.state_flag_imageview)

            val stateInfoBundle = Bundle()
            stateInfoBundle.putString("State Name", stateName)
            stateInfoBundle.putString("State Abbreviation", stateNameAbbreviation)
            stateInfoBundle.putString("State Flag", stateFlag)
            stateInfoBundle.putString("Admitted To Statehood", admittedToStatehood)
            stateInfoBundle.putString("State Capital", stateCapital)
            stateInfoBundle.putString("State Nickname", stateNickname)
            stateInfoBundle.putString("State Population", statePopulation)
            stateInfoBundle.putString("Border States", borderStates)
            stateInfoBundle.putString("State Bird", stateBird)
            stateInfoBundle.putString("State Flower", stateFlower)
            stateInfoBundle.putString("State Tree", stateTree)
            stateInfoBundle.putInt("Total Counties", totalCounties)

            itemView.setOnClickListener { itemView.findNavController().navigate(StatesFragmentDirections.actionStatesFragmentToDisplayInfoFragment(stateName, stateNameAbbreviation, stateFlag,
                admittedToStatehood, stateCapital, stateNickname, statePopulation, borderStates, stateBird, stateFlower, stateTree, totalCounties)) }


        }
    }
}