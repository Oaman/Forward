package com.oman.forward.wanandroid.search

import android.graphics.Bitmap
import androidx.lifecycle.liveData
import com.oman.forward.wanandroid.api.WanAndroidAPI
import com.oman.forward.wanandroid.net.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.resumeCancellableWith
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SearchRepository {

    fun getSearchResult(pageNum: Int, key: String) = fire(Dispatchers.IO) {
//        val result = create(WanAndroidAPI::class.java).getSearchList(pageNum, key)
        val result = create(WanAndroidAPI::class.java).getSearchListCall(pageNum, key).await()
        Result.success(result)
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
            liveData(context) {
                val result = try {
                    block()
                } catch (e: Exception) {
                    Result.failure(e)
                }
                emit(result)
            }

    fun <T> create(clazz: Class<T>) = RetrofitClient.getInstance().create(clazz)

    private suspend inline fun <T> Call<T>.await(): T {
        return suspendCoroutine<T> {
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) it.resumeWith(Result.success(body))
                    else it.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }
            })
        }
    }

    suspend fun bitmapSuspendable(url: String): Int {
        return suspendCoroutine {
            thread {
                try {
                    it.resume(url.toInt())
                } catch (e: java.lang.Exception) {
                    it.resumeWithException(e)
                }
            }
        }
    }
}