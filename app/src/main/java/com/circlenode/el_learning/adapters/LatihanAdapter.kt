package com.circlenode.el_learning.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.entities.Soal

class LatihanAdapter(val listSoal: List<Soal>?, context: Context) : RecyclerView.Adapter<LatihanAdapter.LatihanViewHolder>(){


    val ctx = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatihanViewHolder {
        return LatihanViewHolder(LayoutInflater.from(ctx).inflate(R.layout.activity_latihan,parent,false))
    }

    override fun getItemCount(): Int {
        if(listSoal == null){
            return 0
        }
        return listSoal.size
    }

    override fun onBindViewHolder(holder: LatihanViewHolder, position: Int) {
        holder.textTeks?.text = listSoal!![position].teks
        holder.textPertanyaan?.text = listSoal[position].pertanyaan
        holder.jawabanA?.text =  listSoal[position].jawabanA
        holder.jawabanB?.text = listSoal[position].jawabanB
        holder.jawabanC?.text = listSoal[position].jawabanC
        holder.jawabanD?.text = listSoal[position].jawabanD


    }


    class LatihanViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val textTeks : TextView? = itemView.findViewById(R.id.textTeks)
        val textPertanyaan : TextView ? = itemView.findViewById<TextView>(R.id.textPertanyaan)
        val radioGroup : RadioGroup? = itemView.findViewById<RadioGroup>(R.id.radioGroupPertanyaan)
        val buttonSuara : ImageButton ?= itemView.findViewById<ImageButton>(R.id.buttonSuara)
        val jawabanA: RadioButton? = itemView.findViewById<RadioButton>(R.id.jawabanA)
        val jawabanB : RadioButton? = itemView.findViewById<RadioButton>(R.id.jawabanB)
        val jawabanC : RadioButton? = itemView.findViewById<RadioButton>(R.id.jawabanC)
        val jawabanD : RadioButton? = itemView.findViewById<RadioButton>(R.id.jawabanD)
    }
}