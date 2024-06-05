package com.example.mynavigationbtn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class dataAdapter(private var data: ArrayList<dataClass>): RecyclerView.Adapter<dataAdapter.viewHolder>() {
    class viewHolder (item: View): RecyclerView.ViewHolder(item) {
        val imgHinh: ImageView = item.findViewById(R.id.imgHinh)
        val txtname : TextView = item.findViewById(R.id.txtname)
        val txtage : TextView = item.findViewById(R.id.txtage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val holderview = data[position]
        holder.imgHinh.setImageResource(holderview.img)
        holder.txtname.text = holderview.name
        holder.txtage.text = holderview.age
    }


}