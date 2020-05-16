package com.oman.forward.study.rxjava;

import com.oman.forward.study.rxjava.DataBean;
import com.oman.forward.study.rxjava.RepoBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author:ZhouJiang
 * @date:2020/4/28 21:53
 * @email:zhoujiang2012@163.com
 */
public interface TestInterface {

    @GET("home/homead/{login}/{name}")
    @Headers({"Cache-Control: max-age=640000", "name:beijing", "content-type:application/json"})
    Call<Object> getData(@Query(value = "cityId") String cityId, @Query(value = "age") String age);

    @GET("/users/oaman")
    Call<DataBean> getGithubOman();

    @GET("users/{user}/repos")
    Call<List<RepoBean>> getRepos(@Path("user") String user);
}
