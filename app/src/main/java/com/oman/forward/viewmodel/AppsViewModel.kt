package com.oman.forward.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oman.forward.db.entity.AppEntity
import com.oman.forward.db.repository.AppsRepository

class AppsViewModel(appsRepository: AppsRepository) : ViewModel() {
    val apps: LiveData<List<AppEntity>> = appsRepository.loadApps()
}