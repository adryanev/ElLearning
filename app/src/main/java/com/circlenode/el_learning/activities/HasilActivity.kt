package com.circlenode.el_learning.activities

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom
import com.circlenode.el_learning.R
import kotlinx.android.synthetic.main.activity_hasil.*

class HasilActivity :AppCompatActivity(){


    lateinit var ctx : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)
        ctx = applicationContext
        val skor = intent.getIntExtra("skor",0)
        val jawabanSiswa = intent.getStringArrayListExtra("jawaban")
        val jawabanBenar = intent.getStringArrayListExtra("jawaban_benar")
        var nomor = 1;

        skorSiswa.text = skor.toString()

        val teksNomor = TextView(ctx)
        teksNomor.text = "No"
        teksNomor.setPadding(16,16,16,16)
        val teksJawabanSiswaJudul = TextView(ctx)
        teksJawabanSiswaJudul.text = "Jawaban Anda"
        teksJawabanSiswaJudul.setPadding(16,16,16,16)
        val teksJawabanBenarJudul = TextView(ctx)
        teksJawabanBenarJudul.text = "Jawaban Benar"
        teksJawabanBenarJudul.setPadding(16,16,16,16)
        val tableRowJudul : TableRow = TableRow(ctx)
        tableRowJudul.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)
        tableRowJudul.setPadding(8,8,8,8)

        tableRowJudul.addView(teksNomor,0)
        tableRowJudul.addView(teksJawabanSiswaJudul,1)
        tableRowJudul.addView(teksJawabanBenarJudul,2)
        tabel_jawaban.addView(tableRowJudul)


        while (nomor <= jawabanBenar.size){
            val tableRow : TableRow = TableRow(ctx)
            tableRow.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)
            tableRow.setPadding(8,8,8,8)
            val textNo : TextView = TextView(ctx)
            textNo.text = nomor.toString()
            textNo.gravity = Gravity.CENTER_HORIZONTAL
            textNo.setPadding(16,16,16,16)
            val textJawabanSiswa : TextView = TextView(ctx)
            textJawabanSiswa.text = jawabanSiswa[nomor-1]
            textJawabanSiswa.gravity = Gravity.CENTER_HORIZONTAL
            textJawabanSiswa.setPadding(16,16,16,16)
            val textJawabanBenar: TextView = TextView(ctx)
            textJawabanBenar.gravity = Gravity.CENTER_HORIZONTAL
            textJawabanBenar.text = jawabanBenar[nomor-1]
            textJawabanBenar.setPadding(16,16,16,16)
            if(jawabanSiswa[nomor-1].equals(jawabanBenar[nomor-1])) tableRow.setBackgroundColor(0x3d5afe00)
            tableRow.addView(textNo,0)
            tableRow.addView(textJawabanSiswa,1)
            tableRow.addView(textJawabanBenar,2)
            tabel_jawaban.addView(tableRow)


            nomor++
        }
    }
}
