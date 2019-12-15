package com.oman.forward.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.oman.forward.db.dao.AppsDao
import com.oman.forward.db.dao.CommentsDao
import com.oman.forward.db.entity.AppEntity
import com.oman.forward.db.entity.CommentEntity
import com.oman.forward.worker.AppsWorker
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [AppEntity::class, CommentEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appsDao(): AppsDao

    abstract fun commentsDao(): CommentsDao

    companion object {
        private const val DATABASE_NAME = "forward-db"
        private val executors: ExecutorService = Executors.newSingleThreadExecutor()
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context.applicationContext).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            executors.execute {
                                Thread.sleep(3000)
                                val request: OneTimeWorkRequest = OneTimeWorkRequestBuilder<AppsWorker>().build()
                                WorkManager.getInstance(context).enqueue(request)
                            }
                        }
                    })
                    .build()
        }
    }
}