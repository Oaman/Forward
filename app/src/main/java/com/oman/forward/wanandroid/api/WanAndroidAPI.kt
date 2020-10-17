package com.oman.forward.wanandroid.api

import com.oman.forward.wanandroid.entity.LoginRegisterResponse
import com.oman.forward.wanandroid.entity.RegisterResponseWrapper
import com.oman.forward.wanandroid.entity.SearchResultResponse
import io.reactivex.Observable
import retrofit2.http.*

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


    @POST("/article/query/{pageNum}/json")
    fun getObservableSearchList(@Path("pageNum") pageNum: Int, @Query("k") key: String): Observable<RegisterResponseWrapper<SearchResultResponse>>

    @POST("/article/query/{pageNum}/json")
    suspend fun getSearchList(@Path("pageNum") pageNum: Int, @Query("k") key: String): RegisterResponseWrapper<SearchResultResponse>
}