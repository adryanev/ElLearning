package com.circlenode.el_learning.activities

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.circlenode.el_learning.R
import com.circlenode.el_learning.adapters.KelasPagerAdapter
import kotlinx.android.synthetic.main.activity_kelas.*

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelas)
        setSupportActionBar(toolbar_kelas)
        val actionBar = supportActionBar
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        kelasViewPager.adapter = KelasPagerAdapter(supportFragmentManager)
        tab_kelas.setupWithViewPager(kelasViewPager)


    }

}