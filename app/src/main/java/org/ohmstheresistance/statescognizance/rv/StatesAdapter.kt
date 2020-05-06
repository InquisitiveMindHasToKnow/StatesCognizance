package org.ohmstheresistance.statescognizance.rv

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
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

            itemView.state_name_and_abbreviation_textview.text =
                "$stateName, $stateNameAbbreviation"

            Glide.with(itemView.context)
                .load(stateFlag)
                .into(itemView.state_flag_imageview)

            itemView.setOnClickListener { itemView.findNavController().navigate(StatesFragmentDirections.actionStatesFragmentToDisplayInfoFragment()) }
        }
    }
}