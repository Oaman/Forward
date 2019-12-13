package com.oman.forward.db

import android.content.Context
import com.oman.forward.db.repository.AppsRepository
import com.oman.forward.db.repository.CommentsRepository

object RepositoryProvider {
    /**
     * return the apps repository
     */
    fun providerAppsRepository(context: Context): AppsRepository {
        return AppsRepository.getInstance(AppDatabase.getInstance(context).appsDao())
    }

    fun providerCommentsRepository(context: Context): CommentsRepository {
        return CommentsRepository.getInstance(AppDatabase.getInstance(context).commentsDao())
    }
}