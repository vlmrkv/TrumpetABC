package com.dekram.trumpetabc.views

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dekram.trumpetabc.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var fingerings: TextView
    private lateinit var tones: TextView
    private lateinit var notesCards: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        initViews(view)

        fingerings.setOnClickListener {
            findNavController().navigate(R.id.action_home_fragment_to_fingeringsFragment)
        }

        tones.setOnClickListener {
            findNavController().navigate(R.id.action_home_fragment_to_tonesFragment)
        }

        notesCards.setOnClickListener {
            findNavController().navigate(R.id.action_home_fragment_to_notesCardFragment)
        }
    }

    private fun initViews(view: View) {
        fingerings = view.findViewById(R.id.toFingerings)
        tones = view.findViewById(R.id.toTones)
        notesCards = view.findViewById(R.id.toNotesCards)
    }
}