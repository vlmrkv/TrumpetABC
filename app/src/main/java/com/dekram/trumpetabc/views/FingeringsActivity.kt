package com.dekram.trumpetabc.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dekram.trumpetabc.R

class FingeringsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerings)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, FingeringsActivity::class.java)
        }
    }
}