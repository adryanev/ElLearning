package com.circlenode.el_learning.database

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.circlenode.el_learning.database.dao.MateriDao
import com.circlenode.el_learning.database.dao.SoalDao
import com.circlenode.el_learning.database.entities.Materi
import com.circlenode.el_learning.database.entities.Soal
import com.circlenode.el_learning.utils.DATABASE_NAME
import com.circlenode.el_learning.workers.SeedDatabaseWorker
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

@Database(entities = [Materi::class, Soal::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getMateriDao() : MateriDao
    abstract fun getSoalDao() : SoalDao


    companion object {

        @Volatile private var instance : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase
        {
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance = it }
            }

        }

        fun buildDatabase(context: Context) : AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .addCallback(object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Log.d("AppDatabase","Populating DB")
//                            PopulateDbASync(instance,context).execute()
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                            WorkManager.getInstance().enqueue(request)
                        }
                        }).build()

        }
    }
    class PopulateDbASync(appDatabase: AppDatabase?,context: Context) : AsyncTask<Unit,Unit,Unit>(){
        val materiDao  = appDatabase!!.getMateriDao()
        val soaldao = appDatabase!!.getSoalDao()
        @SuppressLint("StaticFieldLeak")
        val scontext = context
        override fun doInBackground(vararg params: Unit?) {
            val materiType = object : TypeToken<List<Materi>>(){}.type
            val soalType = object : TypeToken<List<Soal>>() {}.type
            var jsonReader: JsonReader? = null
            Log.d("AppDatabase", "database berhasil di build")
            val soalInputStream =scontext.assets.open("soal.json")
            val materiInputStream = scontext.assets.open("materi.json")
            //user json reader to read the json file
            jsonReader = JsonReader(soalInputStream.reader())
            Log.d("SeedDatabaseWorker",jsonReader.toString())
            val soalList: List<Soal> = Gson().fromJson(jsonReader,soalType) //set all data from file to list
            jsonReader = JsonReader(materiInputStream.reader())
            val materiList: List<Materi> = Gson().fromJson(jsonReader,materiType)

            materiDao.insertMateri(materiList) //access the dao to save it to database
            soaldao.insertAllSoal(soalList)
        }

    }

}