package com.dekram.trumpetabc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var fingerings: TextView
    private lateinit var tones: TextView
    private lateinit var notesCards: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        fingerings.setOnClickListener {
            val intent = FingeringsActivity.newIntent(this)
            startActivity(intent)
        }

        tones.setOnClickListener {
            val intent = TonesActivity.newIntent(this)
            startActivity(intent)
        }

        notesCards.setOnClickListener {
            val intent = NotesCardActivity.newIntent(this)
            startActivity(intent)
        }
    }

    private fun initViews() {
        fingerings = findViewById(R.id.toFingerings)
        tones = findViewById(R.id.toTones)
        notesCards = findViewById(R.id.toNotesCards)
    }
}