package com.circlenode.el_learning.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "materi")
data class Materi(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_materi")
        var idMateri: Int,
        var kelas: Int,
        var semester: Int,
        var kategori: String,
        var pertemuan: String,
        var isiMateri: String)