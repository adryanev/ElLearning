package com.circlenode.el_learning.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.circlenode.el_learning.R
import kotlinx.android.synthetic.main.activity_kategori.*


class KategoriActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori)
        setSupportActionBar(toolbar_kategori)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        val kelas : Int = intent.getIntExtra(KelasActivity.KELAS,0)
        val semester : Int = intent.getIntExtra(KelasActivity.SEMESTER,0)
        val pertemuan: Int = intent.getIntExtra("pertemuan", 0)

        if(pertemuan %2 != 0){
            kategori1.text = "reading"
            kategori2.text = "speaking"
        }else{
            kategori1.text = "listening"
            kategori2.text = "writing"
        }


        kategori1.setOnClickListener {
            val kategori : String = kategori1.text.toString()
            val intent : Intent = Intent(this@KategoriActivity, MateriActivity::class.java)
            intent.putExtra(KelasActivity.KELAS,kelas)
            intent.putExtra(KelasActivity.SEMESTER,semester)
            intent.putExtra("pertemuan", pertemuan)
            intent.putExtra("kategori",kategori)
            startActivity(intent)
        }

        kategori2.setOnClickListener {
            val kategori : String = kategori2.text.toString()
            val intent : Intent = Intent(this@KategoriActivity, MateriActivity::class.java)
            intent.putExtra(KelasActivity.KELAS,kelas)
            intent.putExtra(KelasActivity.SEMESTER,semester)
            intent.putExtra("pertemuan", pertemuan)
            intent.putExtra("kategori",kategori)
            startActivity(intent)
        }






    }
}