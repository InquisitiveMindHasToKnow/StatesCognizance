package org.ohmstheresistance.statescognizance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide

import org.ohmstheresistance.statescognizance.R
import org.ohmstheresistance.statescognizance.databinding.DisplayInfoFragmentBinding

class DisplayInfoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<DisplayInfoFragmentBinding>(inflater, R.layout.display_info_fragment, container, false)

        val stateInfoBundle = arguments?.let {DisplayInfoFragmentArgs.fromBundle(it)}

        val stateName = stateInfoBundle?.stateName
        val stateAbbreviation = stateInfoBundle?.stateAbbreviation
        val stateFlag = stateInfoBundle?.stateFlag
        val dateAdmittedToStatehood = stateInfoBundle?.admittedToStatehood

        (activity as AppCompatActivity).supportActionBar?.title = stateName + ", " + stateAbbreviation

        binding.stateAdmissionToStatehoodTextview.text = dateAdmittedToStatehood

        context?.let {
            Glide.with(it)
                .load(stateFlag)
                .into(binding.displayStateFlagImageview)
        }

        return binding.root
    }

}
