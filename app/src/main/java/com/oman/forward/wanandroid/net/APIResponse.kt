package com.oman.forward.wanandroid.net

import com.oman.forward.wanandroid.entity.RegisterResponseWrapper
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class APIResponse<T> : Observer<RegisterResponseWrapper<T>> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: RegisterResponseWrapper<T>) {
        if (t.data != null) {
            success(t.data)
        } else {
            failure("register failure:${t.errorMsg}")
        }
    }

    override fun onError(e: Throwable) {
        failure(e.message)
    }

    abstract fun success(t: T)

    abstract fun failure(errorMsg: String?)

}