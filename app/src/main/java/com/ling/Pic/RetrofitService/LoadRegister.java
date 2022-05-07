package com.ling.Pic.RetrofitService;


import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.bean.User;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LoadRegister {
    @FormUrlEncoded
    @POST("user/register")
    Observable<ResponseData<User>> register(@Field("username") String username,@Field("password" ) String password,
    @Field("repassword") String repassword );
    @FormUrlEncoded
    @POST("user/login")
    Observable<ResponseData<User>> load(@Field("username") String username,@Field("password") String password);
    @GET("user/logout/json")
    Observable<ResponseData<User>> quit();
}
