package com.dekram.trumpetabc.views

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.dekram.trumpetabc.R
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NotesCardActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabs: TabLayout

    private val notesNames = listOf(
        "G#0", "A0", "A#0", "H0", "C1",
        "C#1", "D1", "D#1", "E1", "F1",
        "F#1", "G1", "G#1", "A1", "A#1",
        "H1", "C2", "C#2", "D2", "D#2",
        "E2", "F2", "F#2", "G2", "G#2",
        "A2", "A#2", "H2", "C3"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_card)
        initViews()
        viewPager.adapter = PagerAdapter(this, notesNames)
        TabLayoutMediator(tabs, viewPager) { tabs, position ->
            tabs.text = notesNames[position]
        }.attach()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.view_pager)
        tabs = findViewById(R.id.tabs)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NotesCardActivity::class.java)
        }
    }

}

class PagerAdapter(private val context: Context, private val notesNames: List<String>) :
    RecyclerView.Adapter<PagerAdapter.PageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder =
        PageHolder(LayoutInflater.from(context).inflate(R.layout.item_card, parent, false))

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        holder.notesCard.text = notesNames[position]
        holder.notesView.setImageResource(
            when (position) {
                0 -> R.drawable.nc1_gis0
                1 -> R.drawable.nc2_a0
                2 -> R.drawable.nc3_ais0
                3 -> R.drawable.nc4_h0
                4 -> R.drawable.nc5_c1
                5 -> R.drawable.nc6_cis1
                6 -> R.drawable.nc7_d1
                7 -> R.drawable.nc8_dis1
                8 -> R.drawable.nc9_e1
                9 -> R.drawable.nc10_f1
                10 -> R.drawable.nc11_fis1
                11 -> R.drawable.nc12_g1
                12 -> R.drawable.nc13_gis1
                13 -> R.drawable.nc14_a1
                14 -> R.drawable.nc15_ais1
                15 -> R.drawable.nc16_h1
                16 -> R.drawable.nc17_c2
                17 -> R.drawable.nc18_cis2
                18 -> R.drawable.nc19_d2
                19 -> R.drawable.nc20_dis2
                20 -> R.drawable.nc21_e2
                21 -> R.drawable.nc22_f2
                22 -> R.drawable.nc23_fis2
                23 -> R.drawable.nc24_g2
                24 -> R.drawable.nc25_gis2
                25 -> R.drawable.nc26_a2
                26 -> R.drawable.nc27_ais2
                27 -> R.drawable.nc28_h2
                28 -> R.drawable.nc29_c3
                else -> 0
            }
        )

        val mp3files = listOf(
            R.raw.sounds_01_gis0,
            R.raw.sounds_02_a0,
            R.raw.sounds_03_ais0,
            R.raw.sounds_04_h0,
            R.raw.sounds_05_c1,
            R.raw.sounds_06_cis1,
            R.raw.sounds_07_d1,
            R.raw.sounds_08_dis1,
            R.raw.sounds_09_e1,
            R.raw.sounds_10_f1,
            R.raw.sounds_11_fis1,
            R.raw.sounds_12_g1,
            R.raw.sounds_13_gis1,
            R.raw.sounds_14_a1,
            R.raw.sounds_15_ais1,
            R.raw.sounds_16_h1,
            R.raw.sounds_17_c2,
            R.raw.sounds_18_cis2,
            R.raw.sounds_19_d2,
            R.raw.sounds_20_dis2,
            R.raw.sounds_21_e2,
            R.raw.sounds_22_f2,
            R.raw.sounds_23_fis2,
            R.raw.sounds_24_g2,
            R.raw.sounds_25_gis2,
            R.raw.sounds_26_a2,
            R.raw.sounds_27_ais2,
            R.raw.sounds_28_h2,
            R.raw.sounds_29_c3
        )
        val mp3file = mp3files[position]
        holder.bind(mp3file)
    }

    override fun getItemCount(): Int = notesNames.size


    inner class PageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notesCard: TextView = itemView.findViewById(R.id.notes_card)
        val notesView: ImageView = itemView.findViewById(R.id.notesView)
        private val playButton: ImageView = itemView.findViewById(R.id.play_button)

        fun bind(mp3file: Int) {
            playButton.setOnClickListener {
                val mediaPlayer: MediaPlayer = MediaPlayer.create(itemView.context, mp3file)
                mediaPlayer.start()
            }
        }
    }
}