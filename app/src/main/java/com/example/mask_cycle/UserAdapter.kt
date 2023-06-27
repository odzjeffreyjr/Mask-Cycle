package com.example.mask_cycle

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mask_cycle.User

class UserAdapter(private val context: Context, private val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById<TextView>(R.id.tvName)
        val profilePicture: ImageView = itemView.findViewById(R.id.profilePicture)
        val tvRank: TextView = itemView.findViewById(R.id.tvRank)
        val tvStreak: TextView = itemView.findViewById(R.id.tvStreak)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.tvName.text = currentUser.name
        holder.tvRank.text= currentUser.rank
        holder.profilePicture.setImageResource(currentUser.profilePicture)
        holder.tvStreak.text = currentUser.streak
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}