package com.dekram.trumpetabc.views

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dekram.trumpetabc.MainActivity
import com.dekram.trumpetabc.R
import com.dekram.trumpetabc.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val mainActivity = activity as MainActivity
        val presenter = mainActivity.mainPresenter

        binding?.toTuner?.setOnClickListener {
            presenter.onFingeringsButtonClicked()
        }

        binding?.toTones?.setOnClickListener {
            presenter.onTonesButtonClicked()
        }

        binding?.toNotesCards?.setOnClickListener {
            presenter.onNotesCardsButtonClicked()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}