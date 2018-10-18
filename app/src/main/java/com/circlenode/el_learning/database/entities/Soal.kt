package com.circlenode.el_learning.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "soal")
data class Soal(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name="id")
        var id :Int,
        var kelas:Int,
        var semester:Int,
        var pertemuan: Int,
        var kategori: String,
        var teks: String?,
        var pertanyaan: String,
        var jawabanA :String,
        var jawabanB: String,
        var jawabanC: String,
        var jawabanD: String,
        var jawabanBenar: String,
        var audio : String?
)