package org.ohmstheresistance.statescognizance.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.state_itemview.view.*
import org.ohmstheresistance.statescognizance.R
import org.ohmstheresistance.statescognizance.data.StateInfo

class FlagsAdapter(private val flagList: ArrayList<StateInfo>) :
    RecyclerView.Adapter<FlagsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.flag_itemview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(flagList[position])
    }

    override fun getItemCount(): Int {
        return flagList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(stateInfo: StateInfo) {

            val stateFlag = stateInfo.flag

                Glide.with(itemView.context)
                .load(stateFlag)
                .into(itemView.state_flag_imageview)
        }
    }
}