package com.oman.forward.wanandroid.api

import com.oman.forward.wanandroid.entity.LoginRegisterResponse
import com.oman.forward.wanandroid.entity.RegisterResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WanAndroidAPI {

    @POST("/user/register")
    @FormUrlEncoded
    fun registerAction(@Field("username") username: String,
                       @Field("password") password: String,
                       @Field("repassword") repassword: String): Observable<RegisterResponseWrapper<LoginRegisterResponse>>

    @POST("/user/login")
    @FormUrlEncoded
    fun loginAction(@Field("username") username: String,
                    @Field("password") password: String): Observable<RegisterResponseWrapper<LoginRegisterResponse>>
}