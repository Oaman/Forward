package com.oman.forward.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.oman.forward.db.AppDatabase
import com.oman.forward.db.DataGenerator
import com.oman.forward.db.RepositoryProvider
import com.oman.forward.db.entity.AppEntity
import com.oman.forward.db.entity.CommentEntity
import kotlinx.coroutines.coroutineScope

/**

 * @author:ZhouJiang
 * @date:2019/12/14 15:23
 * @email:zhoujiang2012@163.com

 */
class AppsWorker(context: Context, workerParameters: WorkerParameters)
    : CoroutineWorker(context, workerParameters) {

    private val TAG by lazy {
        AppsWorker::class.java.simpleName
    }

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open("apps.json").use {
                JsonReader(it.reader()).use { reader ->
                    val appsType = object : TypeToken<List<AppEntity>>() {}.type
                    val appsList: List<AppEntity> = Gson().fromJson(reader, appsType)
                    val comments = DataGenerator.getComments(appsList)
                    val appsDao = RepositoryProvider.providerAppsRepository(applicationContext)
                    val commentDao = RepositoryProvider.providerCommentsRepository(applicationContext)
                    appsDao.insertAll(appsList)
                    commentDao.insertAll(comments)
                }
                Result.success()
            }
        } catch (e: Exception) {
            Result.failure()
        }
    }

    private fun insertData(database: AppDatabase, apps: List<AppEntity>, comments: List<CommentEntity>) {
        database.runInTransaction {
            database.appsDao().insertAll(apps)
            database.commentsDao().insertAll(comments)
        }
    }

}