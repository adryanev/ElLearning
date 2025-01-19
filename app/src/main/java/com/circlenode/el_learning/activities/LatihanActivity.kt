package com.circlenode.el_learning.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.repository.SoalRepository
import com.circlenode.el_learning.databinding.ActivityLatihanBinding

class LatihanActivity : AppCompatActivity() {

    lateinit var soalRepository: SoalRepository
    private lateinit var binding: ActivityLatihanBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatihanBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val kelas = intent.getIntExtra(KelasActivity.KELAS,0)
        val semester = intent.getIntExtra(KelasActivity.SEMESTER,0)
        val pertemuan = intent.getIntExtra("pertemuan",0)
        val kategori : String? = intent.getStringExtra("kategori")
        soalRepository = SoalRepository(kelas,semester,pertemuan,kategori!!,application)
        val soalList = soalRepository.getSoal(kelas,semester,pertemuan,kategori)
        Log.d("LatihanActivity",soalList[0].pertanyaan)
        if(soalList[0].teks == null){
            binding.latihanPertanyaan.textTeks.visibility = View.GONE
        }else{
            binding.latihanPertanyaan.textTeks.text = soalList[0].teks
        }
        if(soalList[0].audio == null){
            binding.latihanPertanyaan.buttonSuara.visibility = View.GONE
        }
        else{
          binding.latihanPertanyaan.buttonSuara.setOnClickListener {
              binding.latihanPertanyaan. buttonSuara.setImageResource(R.drawable.ic_pause_black_24dp)
            }
        }
        binding.latihanPertanyaan.textPertanyaan.text = "1. ${soalList[0].pertanyaan}"
        binding.latihanPertanyaan.itemJawaban.jawabanA.text = "A. ${soalList[0].jawabanA}"
        binding.latihanPertanyaan.itemJawaban.jawabanB.text = "B. ${soalList[0].jawabanB}"
        binding.latihanPertanyaan.itemJawaban.jawabanC.text = "C. ${soalList[0].jawabanC}"
        binding.latihanPertanyaan.itemJawaban.jawabanD.text = "D. ${soalList[0].jawabanD}"



    }
}