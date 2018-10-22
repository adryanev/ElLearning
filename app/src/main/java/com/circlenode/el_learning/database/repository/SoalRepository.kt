package com.circlenode.el_learning.database.repository

import com.circlenode.el_learning.database.dao.SoalDao

class SoalRepository private constructor(private val soalDao: SoalDao){

    fun getSoal(kelas: Int, semester: Int, pertemuan: Int, kategori: String) = soalDao.getSoal(kelas,semester,pertemuan,kategori)

    companion object {

        @Volatile private var instance : SoalRepository? = null

        fun getInstance(soalDao : SoalDao) = instance ?: synchronized(this){
            instance ?: SoalRepository(soalDao).also { instance = it }
        }
    }
}