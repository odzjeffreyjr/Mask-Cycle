package com.example.mask_cycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HowItWorksAdapter(private val context: Context, private val howItWorksList: ArrayList<HowItWorksItem>): RecyclerView.Adapter<HowItWorksAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNumbering: TextView = itemView.findViewById<TextView>(R.id.tvNumbering)
        val tvStep: TextView = itemView.findViewById(R.id.tvStep)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.how_it_works_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = howItWorksList[position]
        holder.tvNumbering.text = currentItem.numbering.toString()
        holder.tvStep.text= currentItem.step
        if (position == howItWorksList.lastIndex) {
            holder.tvNumbering.setBackgroundResource(R.color.teal_200)
            holder.tvStep.setTextColor(R.color.black)
        }
    }

    override fun getItemCount(): Int {
        return howItWorksList.size
    }
}