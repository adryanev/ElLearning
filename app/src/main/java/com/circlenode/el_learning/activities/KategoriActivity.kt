package com.circlenode.el_learning.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.circlenode.el_learning.R
import com.circlenode.el_learning.databinding.ActivityKategoriBinding


class KategoriActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKategoriBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKategoriBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbarKategori)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        val kelas : Int = intent.getIntExtra(KelasActivity.KELAS,0)
        val semester : Int = intent.getIntExtra(KelasActivity.SEMESTER,0)
        val pertemuan: Int = intent.getIntExtra("pertemuan", 0)

        if(pertemuan %2 != 0){
            binding.kategori1.text = "reading"
            binding.kategori2.text = "speaking"
        }else{
            binding.kategori1.text = "listening"
            binding.kategori2.text = "writing"
        }


        binding.kategori1.setOnClickListener {
            val kategori : String = binding.kategori1.text.toString()
            val intent : Intent = Intent(this@KategoriActivity, MateriActivity::class.java)
            intent.putExtra(KelasActivity.KELAS,kelas)
            intent.putExtra(KelasActivity.SEMESTER,semester)
            intent.putExtra("pertemuan", pertemuan)
            intent.putExtra("kategori",kategori)
            startActivity(intent)
        }

        binding.kategori2.setOnClickListener {
            val kategori : String = binding.kategori2.text.toString()
            val intent : Intent = Intent(this@KategoriActivity, MateriActivity::class.java)
            intent.putExtra(KelasActivity.KELAS,kelas)
            intent.putExtra(KelasActivity.SEMESTER,semester)
            intent.putExtra("pertemuan", pertemuan)
            intent.putExtra("kategori",kategori)
            startActivity(intent)
        }






    }
}