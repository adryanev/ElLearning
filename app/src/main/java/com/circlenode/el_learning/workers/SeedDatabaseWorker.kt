package com.circlenode.el_learning.workers

import android.content.Context
import com.google.gson.stream.JsonReader
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.circlenode.el_learning.database.AppDatabase
import com.circlenode.el_learning.database.entities.Materi
import com.circlenode.el_learning.database.entities.Soal
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception

class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams){
    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }
    override fun doWork(): ListenableWorker.Result {
        val soalType = object : TypeToken<List<Soal>>() {}.type
        val materiType = object : TypeToken<List<Materi>>(){}.type
        var jsonReader: JsonReader? = null

        return try {
            val database  = AppDatabase.getInstance(applicationContext)
            //get data from json file
            val soalInputStream = applicationContext.assets.open("soal.json")
            val materiInputStream = applicationContext.assets.open("materi.json")
            //user json reader to read the json file
            jsonReader = JsonReader(soalInputStream.reader())
            Log.d("SeedDatabaseWorker",jsonReader.toString())
            val soalList: List<Soal> = Gson().fromJson(jsonReader,soalType) //set all data from file to list
            jsonReader = JsonReader(materiInputStream.reader())
            val materiList: List<Materi> = Gson().fromJson(jsonReader,materiType)

            database.getMateriDao().insertMateri(materiList) //access the dao to save it to database
            database.getSoalDao().insertAllSoal(soalList)

            ListenableWorker.Result.success() //return success

        }catch (ex : Exception){
            Log.e(TAG, "Error seeding database", ex)
            ListenableWorker.Result.failure()
        }finally {
            jsonReader?.close()
        }
    }

}