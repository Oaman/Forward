package com.oman.forward.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oman.forward.db.repository.AppsRepository
import com.oman.forward.viewmodel.AppsViewModel

@Suppress("UNCHECKED_CAST")
class AppsViewModelFactory(private val repository: AppsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AppsViewModel(repository) as T
    }
}