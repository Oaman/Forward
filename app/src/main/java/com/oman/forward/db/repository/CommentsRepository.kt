package com.oman.forward.db.repository

import androidx.lifecycle.LiveData
import com.oman.forward.db.dao.CommentsDao
import com.oman.forward.db.entity.CommentEntity

class CommentsRepository private constructor(private val commentsDao: CommentsDao) {

    fun loadComments(packageName: String): LiveData<List<CommentEntity>> = commentsDao.loadComments(packageName)

    fun insertAll(apps: List<CommentEntity>) = commentsDao.insertAll(apps)

    companion object {
        private var instance: CommentsRepository? = null

        fun getInstance(commentsDao: CommentsDao): CommentsRepository {
            return instance ?: synchronized(this) {
                instance ?: CommentsRepository(commentsDao).also {
                    instance = it
                }
            }
        }
    }
}