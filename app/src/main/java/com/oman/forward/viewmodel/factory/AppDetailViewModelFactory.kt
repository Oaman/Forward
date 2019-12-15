package com.oman.forward.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oman.forward.db.repository.AppsRepository
import com.oman.forward.db.repository.CommentsRepository
import com.oman.forward.viewmodel.AppDetailViewModel

@Suppress("UNCHECKED_CAST")
class AppDetailViewModelFactory(
        private val appsRepository: AppsRepository,
        private val commentsRepository: CommentsRepository,
        private val packageName: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AppDetailViewModel(appsRepository, commentsRepository, packageName) as T
    }
}