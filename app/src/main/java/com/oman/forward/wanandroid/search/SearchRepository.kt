package com.oman.forward.wanandroid.search

import androidx.lifecycle.liveData
import com.oman.forward.wanandroid.api.WanAndroidAPI
import com.oman.forward.wanandroid.net.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object SearchRepository {

    fun getSearchResult(pageNum: Int, key: String) = fire(Dispatchers.IO) {
        val result = create(WanAndroidAPI::class.java).getSearchList(pageNum, key)
        Result.success(result)
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
            liveData {
                val result = try {
                    block()
                } catch (e: Exception) {
                    Result.failure(e)
                }
                emit(result)
            }

    private fun <T> create(clazz:Class<T>) = RetrofitClient.getInstance().create(clazz)
}