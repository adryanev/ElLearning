package com.circlenode.el_learning.activities

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.circlenode.el_learning.R
import com.circlenode.el_learning.adapters.PertemuanAdapter
import com.circlenode.el_learning.database.entities.Pertemuan
import kotlinx.android.synthetic.main.activity_pertemuan.*

class PertemuanActivity : AppCompatActivity() {

    val pertemuanList = Pertemuan.listPertemuan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertemuan)
        val kelas : Int = intent.getIntExtra(KelasActivity.KELAS,0)
        val semester : Int = intent.getIntExtra(KelasActivity.SEMESTER,0)

        prepareToolbar()
        recyclerPertemuan.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recyclerPertemuan.adapter = PertemuanAdapter(kelas, semester, pertemuanList,this)

    }

    fun prepareToolbar(){
        setSupportActionBar(toolbar_pertemuan)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

}