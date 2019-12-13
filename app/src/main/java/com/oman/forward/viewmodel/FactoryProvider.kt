package com.oman.forward.viewmodel

import android.content.Context
import com.oman.forward.db.RepositoryProvider
import com.oman.forward.viewmodel.factory.AppDetailViewModelFactory
import com.oman.forward.viewmodel.factory.AppsViewModelFactory

object FactoryProvider {
    /**
     * return the [AppsViewModelFactory]
     */
    fun providerAppsFactory(context: Context): AppsViewModelFactory {
        return AppsViewModelFactory(RepositoryProvider.providerAppsRepository(context))
    }

    fun providerAppDetailFactory(context: Context, packageName: String): AppDetailViewModelFactory {
        return AppDetailViewModelFactory(RepositoryProvider.providerAppsRepository(context),
                RepositoryProvider.providerCommentsRepository(context),
                packageName)
    }
}