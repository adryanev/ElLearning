package com.circlenode.el_learning.database.repository

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import android.util.Log
import com.circlenode.el_learning.database.AppDatabase
import com.circlenode.el_learning.database.dao.SoalDao
import com.circlenode.el_learning.database.entities.Soal

class SoalRepository(kelas: Int, semester: Int, pertemuan: Int, kategori: String, application: Application) {

    var soalDao: SoalDao
    var list: List<Soal>? = null


    fun getSoal(kelas: Int, semester: Int, pertemuan: Int, kategori: String): List<Soal> {
        return list!!
    }


    init {
        Log.d("SoalRepository" ,"Berhasil masuk ke soal repository")
        val db = AppDatabase.getInstance(application)
        this@SoalRepository.soalDao = db.getSoalDao()
        GetSoalAsync(soalDao).execute(Soal(0,kelas,semester,pertemuan,kategori,"","","","","","","", null)).get()
    }

   @SuppressLint("StaticFieldLeak")
   private inner class GetSoalAsync(soalDao: SoalDao) : AsyncTask<Soal, Unit, Unit>() {
       val dao = soalDao
       override fun doInBackground(vararg params: Soal?) {
            val soalList = dao.getSoal(params[0]!!.kelas,params[0]!!.semester,params[0]!!.pertemuan, params[0]!!.kategori)
           list  = soalList
       }

   }

}