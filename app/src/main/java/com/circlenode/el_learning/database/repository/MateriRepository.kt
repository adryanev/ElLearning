package com.circlenode.el_learning.database.repository

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import android.util.Log
import com.circlenode.el_learning.database.AppDatabase
import com.circlenode.el_learning.database.dao.MateriDao
import com.circlenode.el_learning.database.entities.Materi

class MateriRepository{

    lateinit var materiDao : MateriDao
    var list: List<Materi>? = null
    fun getMateri(kelas : Int, semester: Int, pertemuan: Int, kategori : String ): List<Materi> {
        return list!!
    }
    constructor(kelas : Int, semester: Int, pertemuan: Int, kategori : String ,application: Application){

        Log.d("MateriRepository", "Berhasil masuk ke repository")
        val db : AppDatabase = AppDatabase.getInstance(application)
         this@MateriRepository.materiDao = db.getMateriDao()
         GetMateriAsync(materiDao).execute(Materi(0,kelas,semester,pertemuan,kategori,"")).get()

    }

    constructor(application: Application){
        val db: AppDatabase = AppDatabase.getInstance(application)
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetMateriAsync : AsyncTask<Materi,Unit,Unit> {
         var dao : MateriDao

        override fun doInBackground(vararg params: Materi?){
            val materiList = dao.getMateri(params[0]!!.kelas,params[0]!!.semester,params[0]!!.pertemuan,params[0]!!.kategori)
            list = materiList
        }

        constructor(materiDao: MateriDao){
            dao = materiDao
        }


    }




}