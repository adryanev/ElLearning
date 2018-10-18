package com.circlenode.el_learning.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.circlenode.el_learning.database.AppDatabase
import com.circlenode.el_learning.database.entities.Soal
import com.google.gson.reflect.TypeToken
import java.lang.Exception

class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams){
    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }
    override fun doWork(): Worker.Result {
        val plantType = object : TypeToken<List<Soal>>() {}.type

        return try {
            val database  = AppDatabase.getInstance(applicationContext)
            //TODO: INSERT TO DATABASE

            Worker.Result.SUCCESS

        }catch (ex : Exception){
            Log.e(TAG, "Error seeding database", ex)
            Worker.Result.FAILURE
        }finally {

        }
    }

}