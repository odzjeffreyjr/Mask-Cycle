package com.example.mask_cycle.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mask_cycle.InfoActivity
import com.example.mask_cycle.R
import com.example.mask_cycle.TeamActivity
import com.example.mask_cycle.databinding.FragmentHomeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val activity = activity

        val clMap = _binding!!.clMap

        val joinCompetition = activity?.findViewById<Button>(R.id.joinCompetition)
        joinCompetition?.visibility = View.GONE

        val teamButton = activity?.findViewById<FloatingActionButton>(R.id.teamButton)
        teamButton?.visibility = View.VISIBLE

        val refreshButton = activity?.findViewById<FloatingActionButton>(R.id.refreshButton)
        refreshButton?.visibility = View.VISIBLE
        refreshButton?.setOnClickListener{
            clMap.setBackgroundResource(R.drawable.emptymap)
        }

        val leaderboardButton = activity?.findViewById<FloatingActionButton>(R.id.leaderboardButton)
        leaderboardButton?.visibility = View.VISIBLE

        val infoButton = activity?.findViewById<FloatingActionButton>(R.id.infoButton)
        infoButton?.visibility = View.VISIBLE

        val cvMask = activity?.findViewById<CardView>(R.id.cvMask)
        cvMask?.visibility = View.VISIBLE
        cvMask?.setOnClickListener{
            clMap.setBackgroundResource(R.drawable.bluemap)
        }

        val cvTest = activity?.findViewById<CardView>(R.id.cvTest)
        cvTest?.visibility = View.VISIBLE
        cvTest?.setOnClickListener{
            clMap.setBackgroundResource(R.drawable.yellowmap)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}