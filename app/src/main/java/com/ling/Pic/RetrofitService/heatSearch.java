package com.ling.Pic.RetrofitService;

import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.bean.heatSerach;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface heatSearch {
    @GET("hotkey/json")
    Observable<ResponseData<List<heatSerach> >> getHeatSearch ();
}
