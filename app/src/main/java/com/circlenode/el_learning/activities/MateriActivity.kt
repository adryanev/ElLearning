package com.circlenode.el_learning.activities

import android.app.Application
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.dao.MateriDao
import com.circlenode.el_learning.database.entities.Materi
import com.circlenode.el_learning.database.repository.MateriRepository
import com.circlenode.el_learning.databinding.ActivityMateriBinding
import com.circlenode.el_learning.utils.runOnIoThread
import kotlin.system.exitProcess

class MateriActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMateriBinding
    lateinit var materiRepository : MateriRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMateriBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val kelas = intent.getIntExtra(KelasActivity.KELAS,0)
        val semester = intent.getIntExtra(KelasActivity.SEMESTER,0)
        val pertemuan = intent.getIntExtra("pertemuan",0)
        val kategori : String? = intent.getStringExtra("kategori")
        materiRepository = MateriRepository(kelas,semester,pertemuan,kategori!!,application)
        val listMateri =  materiRepository.getMateri(kelas,semester,pertemuan,kategori)
        Log.d("MateriActivity", listMateri.isEmpty().toString())
        if(listMateri.isEmpty()){
            Log.d("MateriActivity","Materi kosong")
            Toast.makeText(this@MateriActivity,"Materi ini belum ditambahkan",Toast.LENGTH_LONG).show()
            finish()
        }else{
            Log.d("MateriActivity",listMateri[0].fileReference)
            binding.pdfView.fromStream(assets.open(listMateri[0].fileReference)).load()
            binding.btnLatihan.setOnClickListener {
                val i = Intent(this@MateriActivity,LatihanActivity::class.java)
                i.putExtra(KelasActivity.KELAS,kelas)
                i.putExtra(KelasActivity.SEMESTER,semester)
                i.putExtra("pertemuan",pertemuan)
                i.putExtra("kategori",kategori)
                startActivity(i)

            }

        }



    }






}
