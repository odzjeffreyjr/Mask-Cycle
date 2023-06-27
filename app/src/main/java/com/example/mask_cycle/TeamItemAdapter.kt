package com.example.mask_cycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class TeamItemAdapter (private val context: Context, private val teamItemList: ArrayList<TeamItem>): RecyclerView.Adapter<TeamItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTitle: TextView = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvBlab: TextView = itemView.findViewById(R.id.tvBlab)
        val profilePic: ImageView = itemView.findViewById(R.id.profilePic)
        val clPic: ConstraintLayout = itemView.findViewById(R.id.clPic)
        val view3: View = itemView.findViewById(R.id.view3)
        val tvOurTeam: TextView = itemView.findViewById(R.id.tvOurTeam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.team_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = teamItemList[position]
        holder.tvBlab.text = currentItem.body
        holder.tvTitle.text= currentItem.title
        holder.profilePic.setImageResource(currentItem.picture)
        if (position == 0 ){
            holder.tvOurTeam.visibility = View.VISIBLE
            holder.view3.visibility = View.VISIBLE
        }
//       if (position == 1 || position == 3 || position == 5){
//           holder.tvTitle.setBackgroundResource(R.color.teal_200)
//           holder.clPic.setBackgroundResource(R.drawable.message_box_background_alternate)
//       }
    }

    override fun getItemCount(): Int {
        return teamItemList.size
    }
}