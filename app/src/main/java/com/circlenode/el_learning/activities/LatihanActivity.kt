package com.circlenode.el_learning.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.repository.SoalRepository
import kotlinx.android.synthetic.main.item_pertanyaan.*
import kotlinx.android.synthetic.main.layout_jawaban.*

class LatihanActivity : AppCompatActivity() {

    lateinit var soalRepository: SoalRepository
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan)

        val kelas = intent.getIntExtra(KelasActivity.KELAS,0)
        val semester = intent.getIntExtra(KelasActivity.SEMESTER,0)
        val pertemuan = intent.getIntExtra("pertemuan",0)
        val kategori : String? = intent.getStringExtra("kategori")
        soalRepository = SoalRepository(kelas,semester,pertemuan,kategori!!,application)
        val soalList = soalRepository.getSoal(kelas,semester,pertemuan,kategori)
        Log.d("LatihanActivity",soalList[0].pertanyaan)
        if(soalList[0].teks == null){
            textTeks.visibility = View.GONE
        }else{
            textTeks.text = soalList[0].teks
        }
        if(soalList[0].audio == null){
            buttonSuara.visibility = View.GONE
        }
        else{
            buttonSuara.setOnClickListener {
                buttonSuara.setImageResource(R.drawable.ic_pause_black_24dp)
            }
        }
        textPertanyaan.text = "1. ${soalList[0].pertanyaan}"
        jawabanA.text = "A. ${soalList[0].jawabanA}"
        jawabanB.text = "B. ${soalList[0].jawabanB}"
        jawabanC.text = "C. ${soalList[0].jawabanC}"
        jawabanD.text = "D. ${soalList[0].jawabanD}"



    }
}