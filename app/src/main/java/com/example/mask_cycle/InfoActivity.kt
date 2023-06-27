package com.example.mask_cycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val rvHowItWorks = findViewById<RecyclerView>(R.id.rvHowItWorks)
        rvHowItWorks.setHasFixedSize(true)
        val list = setUpList()
        val adapter = HowItWorksAdapter(this, list)
        rvHowItWorks.adapter = adapter
        rvHowItWorks.layoutManager = LinearLayoutManager(this)
    }

    private fun setUpList(): ArrayList<HowItWorksItem> {
        val howItWorksList = ArrayList<HowItWorksItem>()
        val a = HowItWorksItem(1,"Log in to your account")
        val b = HowItWorksItem(2, "Find collection sites near you")
        val c = HowItWorksItem(3, "Visit the collection Site")
        val d = HowItWorksItem(4, "Scan the QR code")
        val e = HowItWorksItem(5,"Insert your masks")
        val f = HowItWorksItem(6, "We'll do the rest!!")
        howItWorksList.apply {
            add(a)
            add(b)
            add(c)
            add(d)
            add(e)
            add(f)
        }
        return howItWorksList
    }
}