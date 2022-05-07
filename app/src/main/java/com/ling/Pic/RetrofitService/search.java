package com.ling.Pic.RetrofitService;

import com.ling.Pic.bean.Article;
import com.ling.Pic.bean.Datas;
import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.bean.ResponseDatas;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface search {
    @POST("article/query/0/json")
    @FormUrlEncoded
    Observable<ResponseData<Datas<List<Article>>>> searchArticle(@Field("k") String s);
}
