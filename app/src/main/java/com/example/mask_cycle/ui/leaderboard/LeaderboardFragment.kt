package com.example.mask_cycle.ui.leaderboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mask_cycle.Login
import com.example.mask_cycle.R
import com.example.mask_cycle.User
import com.example.mask_cycle.UserAdapter
import com.example.mask_cycle.databinding.FragmentLeaderboardBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LeaderboardFragment : Fragment() {

    private var _binding: FragmentLeaderboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val activity = activity
        val leaderboardViewModel =
            ViewModelProvider(this)[LeaderboardViewModel::class.java]

        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)

        val joinCompetition = activity?.findViewById<Button>(R.id.joinCompetition)
        joinCompetition?.visibility = View.VISIBLE
        joinCompetition?.setOnClickListener{
            activity.startActivity(Intent(activity, Login::class.java))
        }

        val teamButton = activity?.findViewById<FloatingActionButton>(R.id.teamButton)
        teamButton?.visibility = View.GONE

        val cvMask = activity?.findViewById<CardView>(R.id.cvMask)
        cvMask?.visibility = View.GONE

        val cvTest = activity?.findViewById<CardView>(R.id.cvTest)
        cvTest?.visibility = View.GONE

        val refreshButton = activity?.findViewById<FloatingActionButton>(R.id.refreshButton)
        refreshButton?.visibility = View.GONE

        val leaderboardButton = activity?.findViewById<FloatingActionButton>(R.id.leaderboardButton)
        leaderboardButton?.visibility = View.GONE

        val infoButton = activity?.findViewById<FloatingActionButton>(R.id.infoButton)
        infoButton?.visibility = View.GONE

        val rvLeaderboard = binding.rvLeaderboard
        rvLeaderboard.setHasFixedSize(true)
        val userList = setUpUserList()
        rvLeaderboard.adapter = activity?.let { UserAdapter(it, userList) }
        rvLeaderboard.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    private fun setUpUserList(): ArrayList<User>{
        val userList = ArrayList<User>()
        val a = User("CrazyMasks101", "#1", "399", R.drawable.man1)
        val b = User("Miffy", "#1", "200", R.drawable.woman4)
        val c =  User("Jeffrey", "#3", "163", R.drawable.man2)
        val d = User("Dachi", "#3", "99", R.drawable.man3)
        val e = User("Arnav", "#3", "101", R.drawable.man8)
        val f = User("GayeKimRecycles", "#6", "50", R.drawable.woman5)
        val g = User("Squidward27", "#7", "41", R.drawable.man9)
        val h = User("MaskCycleUser32", "#8", "72", R.drawable.man10)
        val i = User("Deborah", "#9", "33", R.drawable.woman6)
        val j = User("Arjun", "#10", "33")
        val k = User("Helena", "#11", "7", R.drawable.woman7)
        val l = User("Stylianos", "#12", "9", R.drawable.curly)
        val m = User("Malaika", "#13", "6", R.drawable.woman11)
        val n = User("UgandaBadBoys", "#14", "2", R.drawable.afro)
        val o = User("Kiumars", "#15", "1")
        userList.apply {
            add(a)
            add(b)
            add(c)
            add(d)
            add(e)
            add(f)
            add(g)
            add(h)
            add(i)
            add(j)
            add(k)
            add(l)
            add(m)
            add(n)
            add(o)
        }
        return userList
    }
}