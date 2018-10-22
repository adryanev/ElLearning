package com.circlenode.el_learning.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.circlenode.el_learning.database.entities.Materi

@Dao
interface MateriDao {

    @Query("SELECT * FROM materi WHERE kategori = :kategori and kelas = :kelas and semester = :semester and pertemuan = :pertemuan")
    fun getMateri(kelas: Int, semester : Int, pertemuan : Int,kategori : String) : List<Materi>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMateri(materi: List<Materi>)

}