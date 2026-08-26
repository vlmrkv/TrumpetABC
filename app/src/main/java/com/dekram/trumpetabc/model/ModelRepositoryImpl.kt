package com.dekram.trumpetabc.model

import com.dekram.trumpetabc.R
import com.dekram.trumpetabc.databinding.FragmentTonesBinding
import com.dekram.trumpetabc.databinding.FragmentTunerBinding

class ModelRepositoryImpl : ModelRepository {

    override fun loadTuner(binding: FragmentTunerBinding) {
        binding.tempBanner
    }

    override fun loadTones(binding: FragmentTonesBinding?, arrayResId: Int, position: Int) {
        val drawableRes = when (arrayResId) {
            R.array.minor_tones -> getMinorDrawable(position)
            R.array.major_tones -> getMajorDrawable(position)
            else -> R.drawable.tones_a_dur
        }
        binding?.tones?.setImageResource(drawableRes)
    }

    private fun getMinorDrawable(position: Int): Int = when (position) {
        0 -> R.drawable.tones_a_moll
        1 -> R.drawable.tones_e_moll
        2 -> R.drawable.tones_h_moll
        3 -> R.drawable.tones_fis_moll
        4 -> R.drawable.tones_cis_moll
        5 -> R.drawable.tones_gis_moll
        6 -> R.drawable.tones_dis_moll
        7 -> R.drawable.tones_ais_moll
        8 -> R.drawable.tones_d_moll
        9 -> R.drawable.tones_g_moll
        10 -> R.drawable.tones_c_moll
        11 -> R.drawable.tones_f_moll
        12 -> R.drawable.tones_b_moll
        13 -> R.drawable.tones_es_moll
        14 -> R.drawable.tones_as_moll
        else -> R.drawable.tones_a_moll
    }

    private fun getMajorDrawable(position: Int): Int = when (position) {
        0 -> R.drawable.tones_c_dur
        1 -> R.drawable.tones_g_dur
        2 -> R.drawable.tones_d_dur
        3 -> R.drawable.tones_a_dur
        4 -> R.drawable.tones_e_dur
        5 -> R.drawable.tones_h_dur
        6 -> R.drawable.tones_fis_dur
        7 -> R.drawable.tones_cis_dur
        8 -> R.drawable.tones_f_dur
        9 -> R.drawable.tones_b_dur
        10 -> R.drawable.tones_es_dur
        11 -> R.drawable.tones_as_dur
        12 -> R.drawable.tones_des_dur
        13 -> R.drawable.tones_ges_dur
        14 -> R.drawable.tones_ces_dur
        else -> R.drawable.tones_c_dur
    }

    override fun getNotesData(): List<NoteData> {
        return listOf(
            NoteData("G#0", R.drawable.nc1_gis0, R.raw.sounds_01_gis0),
            NoteData("A0", R.drawable.nc2_a0, R.raw.sounds_02_a0),
            NoteData("A#0", R.drawable.nc3_ais0, R.raw.sounds_03_ais0),
            NoteData("H0", R.drawable.nc4_h0, R.raw.sounds_04_h0),
            NoteData("C1", R.drawable.nc5_c1, R.raw.sounds_05_c1),
            NoteData("C#1", R.drawable.nc6_cis1, R.raw.sounds_06_cis1),
            NoteData("D1", R.drawable.nc7_d1, R.raw.sounds_07_d1),
            NoteData("D#1", R.drawable.nc8_dis1, R.raw.sounds_08_dis1),
            NoteData("E1", R.drawable.nc9_e1, R.raw.sounds_09_e1),
            NoteData("F1", R.drawable.nc10_f1, R.raw.sounds_10_f1),
            NoteData("F#1", R.drawable.nc11_fis1, R.raw.sounds_11_fis1),
            NoteData("G1", R.drawable.nc12_g1, R.raw.sounds_12_g1),
            NoteData("G#1", R.drawable.nc13_gis1, R.raw.sounds_13_gis1),
            NoteData("A1", R.drawable.nc14_a1, R.raw.sounds_14_a1),
            NoteData("A#1", R.drawable.nc15_ais1, R.raw.sounds_15_ais1),
            NoteData("H1", R.drawable.nc16_h1, R.raw.sounds_16_h1),
            NoteData("C2", R.drawable.nc17_c2, R.raw.sounds_17_c2),
            NoteData("C#2", R.drawable.nc18_cis2, R.raw.sounds_18_cis2),
            NoteData("D2", R.drawable.nc19_d2, R.raw.sounds_19_d2),
            NoteData("D#2", R.drawable.nc20_dis2, R.raw.sounds_20_dis2),
            NoteData("E2", R.drawable.nc21_e2, R.raw.sounds_21_e2),
            NoteData("F2", R.drawable.nc22_f2, R.raw.sounds_22_f2),
            NoteData("F#2", R.drawable.nc23_fis2, R.raw.sounds_23_fis2),
            NoteData("G2", R.drawable.nc24_g2, R.raw.sounds_24_g2),
            NoteData("G#2", R.drawable.nc25_gis2, R.raw.sounds_25_gis2),
            NoteData("A2", R.drawable.nc26_a2, R.raw.sounds_26_a2),
            NoteData("A#2", R.drawable.nc27_ais2, R.raw.sounds_27_ais2),
            NoteData("H2", R.drawable.nc28_h2, R.raw.sounds_28_h2),
            NoteData("C3", R.drawable.nc29_c3, R.raw.sounds_29_c3)
        )
    }
}