package com.oman.forward.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oman.forward.db.entity.AppEntity

@Dao
interface AppsDao {

    @Query("SELECT * FROM apps")
    fun loadApps(): LiveData<List<AppEntity>>

    @Query("SELECT * FROM apps WHERE packageName = :packageName")
    fun loadApp(packageName: String): LiveData<AppEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(apps: List<AppEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(app: AppEntity)

    @Delete
    fun delete(app: AppEntity)

    @Update
    fun update(app: AppEntity)
}