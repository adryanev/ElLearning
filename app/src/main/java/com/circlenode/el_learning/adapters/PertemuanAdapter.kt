package com.circlenode.el_learning.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.circlenode.el_learning.R

class PertemuanAdapter (val items: List<String>, context: Context) : RecyclerView.Adapter<PertemuanAdapter.PertemuanViewHolder>() {

    override fun onBindViewHolder(holder: PertemuanViewHolder, position: Int) {

        holder.textPertemuan?.text = items.get(position)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PertemuanViewHolder {
        return PertemuanViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_pertemuan,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PertemuanViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var textPertemuan = itemView.findViewById<TextView>(R.id.textPertemuan)
    }

}