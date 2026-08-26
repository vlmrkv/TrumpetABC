package com.dekram.trumpetabc.model

import com.dekram.trumpetabc.databinding.FragmentTonesBinding
import com.dekram.trumpetabc.databinding.FragmentTunerBinding

interface ModelRepository {

    fun loadTuner(binding: FragmentTunerBinding)

    fun loadTones(binding: FragmentTonesBinding?, arrayResId: Int, position: Int)

    fun getNotesData(): List<NoteData>
}