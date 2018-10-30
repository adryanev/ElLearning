package com.circlenode.el_learning.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.AppDatabase
import com.facebook.stetho.Stetho
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Stetho.initializeWithDefaults(this)

        initDB()
       buttonMulai.setOnClickListener{
           val intent = Intent(this@MainActivity, KelasActivity::class.java)
           startActivity(intent)
       }

        buttonHelp.setOnClickListener{
            val intent = Intent(this@MainActivity, HelpActivity::class.java)
            startActivity(intent)
        }

        buttonExit.setOnClickListener{
            finish()
        }

    }

    private fun initDB() {
        val appDatabase : AppDatabase = AppDatabase.getInstance(applicationContext)

    }
}
