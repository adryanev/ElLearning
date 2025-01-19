package com.circlenode.el_learning.activities

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.AppDatabase
import com.circlenode.el_learning.database.repository.MateriRepository
import com.circlenode.el_learning.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val materi : MateriRepository = MateriRepository(0,0,0,"",application)
        val s =  materi.getMateri(0,0,0,"")
        DbAsync(application).execute()

    }

    @SuppressLint("StaticFieldLeak")
    private inner class DbAsync(application: Application) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            Log.d("SplashActivity","Doing background initialization")


        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            Handler().postDelayed({
                startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                finish()
            },5000)
        }

    }
}