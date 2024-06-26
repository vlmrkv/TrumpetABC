package com.dekram.trumpetabc.views

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.fragment.app.Fragment
import com.dekram.trumpetabc.R

class TonesFragment : Fragment(R.layout.fragment_tones), AdapterView.OnItemSelectedListener {

    private lateinit var tonesViewImage: ImageView
    private lateinit var minorSpinner: Spinner
    private lateinit var majorSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        initViews()
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.minor_tones,
                android.R.layout.simple_spinner_item
            ).also { minorAdapter ->
                minorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                minorSpinner.adapter = minorAdapter
            }
        }

        minorSpinner.onItemSelectedListener = this

        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.major_tones,
                android.R.layout.simple_spinner_item
            ).also { majorAdapter ->
                majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                majorSpinner.adapter = majorAdapter
            }
        }

        majorSpinner.onItemSelectedListener = this
    }

    private fun initViews() {
        tonesViewImage = view?.findViewById(R.id.tones) as ImageView
        minorSpinner = view?.findViewById(R.id.minor_spinner) as Spinner
        majorSpinner = view?.findViewById(R.id.major_spinner) as Spinner
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        if (parent?.id == R.id.minor_spinner) {
            val minorArray = resources.getStringArray(R.array.minor_tones)
            when (minorArray.indexOf(minorArray[position])) {
                0 -> tonesViewImage.setImageResource(R.drawable.tones_a_moll)
                1 -> tonesViewImage.setImageResource(R.drawable.tones_e_moll)
                2 -> tonesViewImage.setImageResource(R.drawable.tones_h_moll)
                3 -> tonesViewImage.setImageResource(R.drawable.tones_fis_moll)
                4 -> tonesViewImage.setImageResource(R.drawable.tones_cis_moll)
                5 -> tonesViewImage.setImageResource(R.drawable.tones_gis_moll)
                6 -> tonesViewImage.setImageResource(R.drawable.tones_dis_moll)
                7 -> tonesViewImage.setImageResource(R.drawable.tones_ais_moll)
                8 -> tonesViewImage.setImageResource(R.drawable.tones_d_moll)
                9 -> tonesViewImage.setImageResource(R.drawable.tones_g_moll)
                10 -> tonesViewImage.setImageResource(R.drawable.tones_c_moll)
                11 -> tonesViewImage.setImageResource(R.drawable.tones_f_moll)
                12 -> tonesViewImage.setImageResource(R.drawable.tones_b_moll)
                13 -> tonesViewImage.setImageResource(R.drawable.tones_es_moll)
                14 -> tonesViewImage.setImageResource(R.drawable.tones_as_moll)
            }
        }

        if (parent?.id == R.id.major_spinner) {
            val majorArray = resources.getStringArray(R.array.major_tones)
            when (majorArray.indexOf(majorArray[position])) {
                0 -> tonesViewImage.setImageResource(R.drawable.tones_c_dur)
                1 -> tonesViewImage.setImageResource(R.drawable.tones_g_dur)
                2 -> tonesViewImage.setImageResource(R.drawable.tones_d_dur)
                3 -> tonesViewImage.setImageResource(R.drawable.tones_a_dur)
                4 -> tonesViewImage.setImageResource(R.drawable.tones_e_dur)
                5 -> tonesViewImage.setImageResource(R.drawable.tones_h_dur)
                6 -> tonesViewImage.setImageResource(R.drawable.tones_fis_dur)
                7 -> tonesViewImage.setImageResource(R.drawable.tones_cis_dur)
                8 -> tonesViewImage.setImageResource(R.drawable.tones_f_dur)
                9 -> tonesViewImage.setImageResource(R.drawable.tones_b_dur)
                10 -> tonesViewImage.setImageResource(R.drawable.tones_es_dur)
                11 -> tonesViewImage.setImageResource(R.drawable.tones_as_dur)
                12 -> tonesViewImage.setImageResource(R.drawable.tones_des_dur)
                13 -> tonesViewImage.setImageResource(R.drawable.tones_ges_dur)
                14 -> tonesViewImage.setImageResource(R.drawable.tones_ces_dur)
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        return
    }

}