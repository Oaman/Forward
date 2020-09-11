package com.oman.token;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface WanAndroidApi {

    @Token(value = false)
    @GET("banner/json")
    Observable<Bean> getBanner();

    @Token
    @GET("friend/json")
    Observable<Bean> getFriend();
}
