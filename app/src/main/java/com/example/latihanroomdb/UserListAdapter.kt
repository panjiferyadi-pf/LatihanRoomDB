package com.example.latihanroomdb

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanroomdb.data.User
import org.w3c.dom.Text

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()
    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_row,parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.tvId).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.tvFirstName).text = currentItem.firstName.toString()
        holder.itemView.findViewById<TextView>(R.id.tvLastname).text = currentItem.lastName.toString()
        holder.itemView.findViewById<TextView>(R.id.tvAge).text = currentItem.age.toString()

        holder.itemView.findViewById<LinearLayout>(R.id.rowLayout).setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment3(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    //setData
    fun setData(user: List<User>){
        this.userList = user
        Log.d("User", user.toString())
        notifyDataSetChanged()
    }
}