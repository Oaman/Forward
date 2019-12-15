package com.oman.forward.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oman.forward.db.entity.AppEntity
import com.oman.forward.db.entity.CommentEntity
import com.oman.forward.db.repository.AppsRepository
import com.oman.forward.db.repository.CommentsRepository

class AppDetailViewModel(
        appsRepository: AppsRepository,
        commentsRepository: CommentsRepository,
        packageName: String
) : ViewModel() {
    val app: LiveData<AppEntity> = appsRepository.loadApp(packageName)
    val comments: LiveData<List<CommentEntity>> = commentsRepository.loadComments(packageName)
    var myApp: ObservableField<AppEntity> = ObservableField()
}