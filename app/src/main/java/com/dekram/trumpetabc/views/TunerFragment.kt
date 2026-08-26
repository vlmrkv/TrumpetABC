package com.dekram.trumpetabc.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dekram.trumpetabc.R
import com.dekram.trumpetabc.databinding.FragmentTunerBinding
import com.dekram.trumpetabc.model.ModelRepositoryImpl

class TunerFragment : Fragment(R.layout.fragment_tuner) {

    private var _binding: FragmentTunerBinding? = null
    private val binding get() = _binding
    private val repositoryImpl = ModelRepositoryImpl()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTunerBinding.bind(view)
        binding?.let { repositoryImpl.loadTuner(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}