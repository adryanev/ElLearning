package com.circlenode.el_learning.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.circlenode.el_learning.R
import com.circlenode.el_learning.activities.KategoriActivity
import com.circlenode.el_learning.activities.KelasActivity
import com.circlenode.el_learning.activities.MateriActivity
import java.util.regex.Pattern

class PertemuanAdapter (val kelas: Int, val semester : Int, val items: List<String>, context: Context) : RecyclerView.Adapter<PertemuanAdapter.PertemuanViewHolder>() {

    val contextAct = context
    override fun onBindViewHolder(holder: PertemuanViewHolder, position: Int) {

        holder.textPertemuan?.text = items.get(position)
        holder.textPertemuan?.setOnClickListener {
            val pertemuan :Int = holder.textPertemuan.text.split("\\s+".toRegex())[1].toInt()
            val intent = Intent(contextAct, KategoriActivity::class.java)
            intent.putExtra(KelasActivity.KELAS,kelas)
            intent.putExtra(KelasActivity.SEMESTER,semester)
            intent.putExtra("pertemuan",pertemuan)
            contextAct.startActivity(intent)



        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PertemuanViewHolder {
        return PertemuanViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pertemuan,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PertemuanViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var textPertemuan = itemView.findViewById<TextView>(R.id.textPertemuan)
    }

}