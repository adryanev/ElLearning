package com.circlenode.el_learning.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.circlenode.el_learning.database.entities.Pertemuan
import com.circlenode.el_learning.database.entities.Soal

@Dao
interface SoalDao {


    @Insert
    fun insertSoal(kelas: Int,
                   semester : Int,
                   pertemuan : Int,
                   kategori : String,
                   pertanyaan : String,
                   jawabanA: String,
                   jawabanB: String,
                   jawabanC: String,
                   jawabanD : String,
                   jawabanBenar : String,
                   gambar : String?,
                   audio : String?)

    @Query("SELECT * FROM soal where kelas = :kelas and semester = :semester and pertemuan = :pertemuan and kategori = :kategori ORDER BY id")
    fun getSoal(kelas: Int, semester : Int, pertemuan : Int, kategori : String) : List<Soal>
}