package com.circlenode.el_learning.activities

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.circlenode.el_learning.R
import com.circlenode.el_learning.adapters.PertemuanAdapter
import com.circlenode.el_learning.database.entities.Pertemuan
import com.circlenode.el_learning.databinding.ActivityPertemuanBinding

class PertemuanActivity : AppCompatActivity() {

    val pertemuanList = Pertemuan.listPertemuan
    private lateinit var binding: ActivityPertemuanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPertemuanBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val kelas : Int = intent.getIntExtra(KelasActivity.KELAS,0)
        val semester : Int = intent.getIntExtra(KelasActivity.SEMESTER,0)

        prepareToolbar()
        binding.recyclerPertemuan.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        binding.recyclerPertemuan.adapter = PertemuanAdapter(kelas, semester, pertemuanList,this)

    }

    fun prepareToolbar(){
        setSupportActionBar(binding.toolbarPertemuan)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

}