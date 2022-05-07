package com.ling.Pic.RetrofitService;

import com.ling.Pic.bean.Picture;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;


public interface getHeat {
    @GET("getHeat")
    Observable<List<Picture>> getHeat();
}
