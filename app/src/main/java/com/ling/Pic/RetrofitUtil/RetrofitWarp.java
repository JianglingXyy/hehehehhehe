package com.ling.Pic.RetrofitUtil;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
//http://120.78.237.178:8089
public class RetrofitWarp {
    public static  Retrofit GsonRetro(){
        return new Retrofit.Builder().
                baseUrl("https://www.wanandroid.com/").
                addCallAdapterFactory(RxJava3CallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                build();
    }

}
