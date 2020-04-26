package org.ohmstheresistance.statescognizance.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.state_itemview.view.*
import org.ohmstheresistance.statescognizance.R
import org.ohmstheresistance.statescognizance.data.StateInfo

class StatesAdapter(private val stateList: ArrayList<StateInfo>) : RecyclerView.Adapter<StatesAdapter.ViewHolder>() {
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

        fun bindItems(stateInfo: StateInfo) {
            itemView.state_name_textview.text = stateInfo.name
            itemView.state_abbreviation_textview.text = stateInfo.abbreviation

        }
}
}