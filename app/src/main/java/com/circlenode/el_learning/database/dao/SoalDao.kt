package com.circlenode.el_learning.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.circlenode.el_learning.database.entities.Pertemuan
import com.circlenode.el_learning.database.entities.Soal

@Dao
interface SoalDao {


    @Insert
    fun insertSoal(soal : Soal)

    @Query("SELECT * FROM soal where kelas = :kelas and semester = :semester and pertemuan = :pertemuan and kategori = :kategori LIMIT 10")
    fun getSoal(kelas: Int, semester : Int, pertemuan : Int, kategori : String) : List<Soal>

    @Insert
    fun insertAllSoal(soalList:List<Soal>)

}