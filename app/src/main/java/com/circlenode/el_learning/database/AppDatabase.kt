package com.circlenode.el_learning.database

import android.content.Context
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

@Database(entities = [Materi::class, Soal::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase(){

    abstract fun getMateriDao() : MateriDao
    abstract fun getSoalMateri() : SoalDao

    companion object {

        @Volatile private var instance : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase
        {
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance = it }
            }

        }

        private fun buildDatabase(context: Context) : AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .addCallback(object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                            WorkManager.getInstance().enqueue(request)
                        }
                        }).build()

        }
    }

}