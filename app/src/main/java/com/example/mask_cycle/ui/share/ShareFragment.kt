package com.example.mask_cycle.ui.share

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mask_cycle.R
import com.example.mask_cycle.databinding.FragmentConnectBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShareFragment : Fragment() {

    private var _binding: FragmentConnectBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val shareViewModel =
            ViewModelProvider(this).get(ShareViewModel::class.java)

        val activity = activity

        val joinCompetition = activity?.findViewById<Button>(R.id.joinCompetition)
        joinCompetition?.visibility = View.GONE

        val teamButton = activity?.findViewById<FloatingActionButton>(R.id.teamButton)
        teamButton?.visibility = View.GONE

        val refreshButton = activity?.findViewById<FloatingActionButton>(R.id.refreshButton)
        refreshButton?.visibility = View.GONE

        val leaderboardButton = activity?.findViewById<FloatingActionButton>(R.id.leaderboardButton)
        leaderboardButton?.visibility = View.GONE

        val infoButton = activity?.findViewById<FloatingActionButton>(R.id.infoButton)
        infoButton?.visibility = View.GONE

        val cvMask = activity?.findViewById<CardView>(R.id.cvMask)
        cvMask?.visibility = View.GONE

        val cvTest = activity?.findViewById<CardView>(R.id.cvTest)
        cvTest?.visibility = View.GONE

        _binding = FragmentConnectBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}