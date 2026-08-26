package com.dekram.trumpetabc.views

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.dekram.trumpetabc.R
import com.dekram.trumpetabc.databinding.FragmentTonesBinding
import com.dekram.trumpetabc.model.ModelRepositoryImpl

class TonesFragment : Fragment(R.layout.fragment_tones), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentTonesBinding? = null
    private val binding
        get() = _binding

    private val repositoryImpl = ModelRepositoryImpl()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        _binding = FragmentTonesBinding.bind(view)

        binding?.minorSpinner?.adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.minor_tones,
            R.layout.spinner_item
        ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        binding?.majorSpinner?.adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.major_tones,
            R.layout.spinner_item
        ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        binding?.minorSpinner?.onItemSelectedListener = this
        binding?.majorSpinner?.onItemSelectedListener = this

        repositoryImpl.loadTones(binding, R.array.minor_tones, 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        val arrayResId = when (parent?.id) {
            R.id.minor_spinner -> R.array.minor_tones
            R.id.major_spinner -> R.array.major_tones
            else -> return
        }
        repositoryImpl.loadTones(binding, arrayResId, position)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        return
    }
}