package com.oman.forward.study.rxjava.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author:ZhouJiang
 * @date:2020/5/27 21:04
 * @email:zhoujiang2012@163.com
 */
public interface RetrofitApi {
    @GET("/v3/weather/weatherInfo")
    Call<ResponseBody> getWeather(@Query("city") String city, @Query("key") String key);
}
