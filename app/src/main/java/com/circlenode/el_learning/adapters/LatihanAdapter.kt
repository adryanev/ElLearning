package com.circlenode.el_learning.adapters

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.entities.Soal
import com.circlenode.el_learning.utils.AudioPlay

class LatihanAdapter(val listSoal: List<Soal>?, context: Context) : RecyclerView.Adapter<LatihanAdapter.LatihanViewHolder>(){

    val ctx = context
    val assetManager : AssetManager = ctx.assets

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
        if(listSoal[position].audio == null) {
            holder.buttonSuara?.visibility = View.GONE

        }else{
            holder.buttonSuara?.setOnClickListener { _ ->
                holder.buttonSuara.setImageResource(R.drawable.ic_pause_black_24dp)
                if(AudioPlay.isPlayingAudio){
                    holder.buttonSuara.setImageResource(R.drawable.ic_volume_up_black_24dp)
                    AudioPlay.stopAudio()
                }
                else{
                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

                    val assetFileDescriptor = assetManager.openFd(listSoal[position].audio)
                    AudioPlay.playAudio(ctx, assetFileDescriptor)
                    holder.buttonSuara.setImageResource(R.drawable.ic_pause_black_24dp)
                }
                AudioPlay.mediaPlayer.setOnCompletionListener {
                    holder.buttonSuara.setImageResource(R.drawable.ic_volume_up_black_24dp)
                    it.stop()

                }

            }
        }



    }


    class LatihanViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val textTeks : TextView? = itemView.findViewById(R.id.textTeks)
        val textPertanyaan : TextView ? = itemView.findViewById<TextView>(R.id.textPertanyaan)
        val buttonSuara : ImageButton ?= itemView.findViewById<ImageButton>(R.id.buttonSuara)
        val jawabanA: RadioButton? = itemView.findViewById<RadioButton>(R.id.jawabanA)
        val jawabanB : RadioButton? = itemView.findViewById<RadioButton>(R.id.jawabanB)
        val jawabanC : RadioButton? = itemView.findViewById<RadioButton>(R.id.jawabanC)
        val jawabanD : RadioButton? = itemView.findViewById<RadioButton>(R.id.jawabanD)
    }
}