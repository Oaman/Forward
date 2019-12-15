package com.oman.forward.db.repository

import androidx.lifecycle.LiveData
import com.oman.forward.db.dao.AppsDao
import com.oman.forward.db.entity.AppEntity

class AppsRepository private constructor(private val appsDao: AppsDao) {

    fun loadApps(): LiveData<List<AppEntity>> = appsDao.loadApps()

    fun loadApp(packageName: String): LiveData<AppEntity> = appsDao.loadApp(packageName)

    fun insertAll(apps: List<AppEntity>) = appsDao.insertAll(apps)

    fun insert(app: AppEntity) = appsDao.insert(app)

    fun delete(app: AppEntity) = appsDao.delete(app)

    fun update(app: AppEntity) = appsDao.update(app)

    companion object {

        @Volatile
        private var instance: AppsRepository? = null

        fun getInstance(appsDao: AppsDao): AppsRepository {
            return instance ?: synchronized(this) {
                instance ?: AppsRepository(appsDao).also {
                    instance = it
                }
            }
        }
    }
}