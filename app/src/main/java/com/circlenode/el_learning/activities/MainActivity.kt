package com.circlenode.el_learning.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.AppDatabase
import com.circlenode.el_learning.databinding.ActivityMainBinding
import com.facebook.stetho.Stetho
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Stetho.initializeWithDefaults(this)

        initDB()
       binding.buttonMulai.setOnClickListener{
           val intent = Intent(this@MainActivity, KelasActivity::class.java)
           startActivity(intent)
       }

        binding.buttonHelp.setOnClickListener{
            val intent = Intent(this@MainActivity, HelpActivity::class.java)
            startActivity(intent)
        }

        binding.buttonExit.setOnClickListener{
            finish()
        }

    }

    private fun initDB() {
        val appDatabase : AppDatabase = AppDatabase.getInstance(applicationContext)

    }
}
