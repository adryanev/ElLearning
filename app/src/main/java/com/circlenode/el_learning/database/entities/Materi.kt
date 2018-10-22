package com.circlenode.el_learning.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "materi")
data class Materi(
        @PrimaryKey(autoGenerate = true)
        var idMateri: Int,
        var kelas: Int,
        var semester: Int,
        var pertemuan: Int,
        var kategori: String,
        var fileReference: String)