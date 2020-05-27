package com.oman.forward.study.rxjava.self;

import okhttp3.Call;
import okhttp3.ResponseBody;

/**
 * @author:ZhouJiang
 * @date:2020/5/27 21:04
 * @email:zhoujiang2012@163.com
 */
public interface RetrofitSelfApi {
    @GET("/v3/weather/weatherInfo")
    okhttp3.Call getWeather(@Query("city") String city, @Query("key") String key);


    @POST("/v3/weather/weatherInfo")
    Call postWeather(@Field("city") String city, @Field("key") String key);
}
