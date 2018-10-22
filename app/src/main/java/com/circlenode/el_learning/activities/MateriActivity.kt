package com.circlenode.el_learning.activities

import android.app.Application
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.dao.MateriDao
import com.circlenode.el_learning.database.entities.Materi
import com.circlenode.el_learning.database.repository.MateriRepository
import com.circlenode.el_learning.utils.runOnIoThread
import kotlinx.android.synthetic.main.activity_materi.*

class MateriActivity : AppCompatActivity() {

    lateinit var materiRepository : MateriRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        val kelas = intent.getIntExtra(KelasActivity.KELAS,0)
        val semester = intent.getIntExtra(KelasActivity.SEMESTER,0)
        val pertemuan = intent.getIntExtra("pertemuan",0)
        val kategori : String? = intent.getStringExtra("kategori")
        materiRepository = MateriRepository(kelas,semester,pertemuan,kategori!!,application)
        val listMateri =  materiRepository.getMateri(kelas,semester,pertemuan,kategori)
        Log.d("MateriActivity",listMateri[0].fileReference)
        pdfView.fromStream(assets.open(listMateri[0].fileReference)).load()
        btnLatihan.setOnClickListener {
            val i = Intent(this@MateriActivity,LatihanActivity::class.java)
            i.putExtra(KelasActivity.KELAS,kelas)
            i.putExtra(KelasActivity.SEMESTER,semester)
            i.putExtra("pertemuan",pertemuan)
            i.putExtra("kategori",kategori)
            startActivity(i)

        }



    }






}
