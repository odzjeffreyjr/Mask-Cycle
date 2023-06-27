package com.example.mask_cycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TeamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
        val rvTeam = findViewById<RecyclerView>(R.id.rvTeam)
        val contentList = setUpContentList()
        rvTeam.adapter = TeamItemAdapter(this, contentList)
        rvTeam.layoutManager = LinearLayoutManager(this)
    }

    private fun setUpContentList(): ArrayList<TeamItem> {
        val list  = ArrayList<TeamItem>()
        val a = TeamItem("Our Mission",getString(R.string.mission), R.drawable.masks)
        val b = TeamItem("Arnav Singhal",getString(R.string.arnav) , R.drawable.arnav)
        val c = TeamItem("Oduman Jeffrey", getString(R.string.jeffrey), R.drawable.jeffrey)
        val d = TeamItem("Miffy Wang",getString(R.string.miffy) , R.drawable.miffy)
        val e = TeamItem("Dachi Gvinadze", getString(R.string.dachi), R.drawable.dachi)
        list.apply {
            add(a)
            add(b)
            add(c)
            add(d)
            add(e)
        }
        return list
    }
}