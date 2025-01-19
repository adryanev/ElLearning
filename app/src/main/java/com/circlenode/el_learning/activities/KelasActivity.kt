package com.circlenode.el_learning.activities

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.circlenode.el_learning.R
import com.circlenode.el_learning.adapters.KelasPagerAdapter
import com.circlenode.el_learning.databinding.ActivityKelasBinding

class KelasActivity : AppCompatActivity() {

    companion object {
        const val KELAS : String = "kelas"
        const val SEMESTER : String = "semester"
        const val SEMESTER_SATU : Int = 1
        const val SEMESTER_DUA : Int = 2
        const val KELAS_TUJUH : Int = 7
        const val KELAS_DELAPAN : Int = 8
        const val KELAS_SEMBILAN : Int = 9
    }

    private lateinit var binding: ActivityKelasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKelasBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbarKelas)
        val actionBar = supportActionBar
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        binding.kelasViewPager.adapter = KelasPagerAdapter(supportFragmentManager)
        binding.tabKelas.setupWithViewPager(binding.kelasViewPager)


    }

}