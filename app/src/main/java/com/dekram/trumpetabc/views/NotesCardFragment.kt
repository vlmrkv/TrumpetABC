package com.dekram.trumpetabc.views

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dekram.trumpetabc.R
import com.dekram.trumpetabc.databinding.FragmentNotesCardBinding
import com.dekram.trumpetabc.model.ModelRepositoryImpl
import com.dekram.trumpetabc.model.NoteData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NotesCardFragment : Fragment(R.layout.fragment_notes_card) {

    private var _binding: FragmentNotesCardBinding? = null
    private val binding
        get() = _binding

    private val repositoryImpl = ModelRepositoryImpl()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        _binding = FragmentNotesCardBinding.bind(view)

        val notesData = repositoryImpl.getNotesData()
        val viewPager: ViewPager2 = binding?.viewPager ?: return
        val tabs: TabLayout = binding?.tabs ?: return

        viewPager.adapter = PagerAdapter(notesData)
        TabLayoutMediator(tabs, viewPager) { tabs, position ->
            tabs.text = notesData[position].name
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

class PagerAdapter(private val notesData: List<NoteData>) :
    RecyclerView.Adapter<PagerAdapter.PageHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder =
        PageHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false))

    override fun onBindViewHolder(holder: PageHolder, positionId: Int) {
        val item = notesData[positionId]
        holder.notesCard.text = item.name
        holder.notesView.setImageResource(item.drawableRes)
        holder.bind(item.soundRes)
    }

    override fun getItemCount(): Int = notesData.size

    inner class PageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notesCard: TextView = itemView.findViewById(R.id.action_from_home_to_notescards)
        val notesView: ImageView = itemView.findViewById(R.id.notesView)
        private val playButton: ImageView = itemView.findViewById(R.id.play_button)

        fun bind(soundRes: Int) {
            playButton.setOnClickListener {
                val mediaPlayer: MediaPlayer = MediaPlayer.create(itemView.context, soundRes)
                mediaPlayer.setOnCompletionListener { mp ->
                    mp.release()
                }
                mediaPlayer.start()
            }
        }
    }
}