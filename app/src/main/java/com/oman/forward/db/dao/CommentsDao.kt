package com.oman.forward.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oman.forward.db.entity.CommentEntity

@Dao
interface CommentsDao {
    @Query("SELECT * FROM comments WHERE packageName = :packageName")
    fun loadComments(packageName: String): LiveData<List<CommentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(apps: List<CommentEntity>)
}