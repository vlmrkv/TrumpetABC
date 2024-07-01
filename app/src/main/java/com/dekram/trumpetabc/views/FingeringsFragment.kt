package com.dekram.trumpetabc.views

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.dekram.trumpetabc.R

class FingeringsFragment : Fragment(R.layout.fragment_fingerings) {

    private lateinit var imageFingerings: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        initView(view)
    }

    private fun initView(view: View) {
        imageFingerings = view.findViewById(R.id.fingerings_image)
    }
}