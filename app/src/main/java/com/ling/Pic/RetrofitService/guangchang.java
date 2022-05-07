package com.ling.Pic.RetrofitService;


import com.ling.Pic.bean.Article;
import com.ling.Pic.bean.Datas;
import com.ling.Pic.bean.ResponseData;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface guangchang {
    @GET("user_article/list/{page}/json")
    Observable<ResponseData<Datas<List<Article>>>> getGuangchang(@Path("page")int page);



}
