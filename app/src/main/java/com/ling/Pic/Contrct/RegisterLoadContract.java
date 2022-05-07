package com.ling.Pic.Contrct;

import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.bean.User;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegisterLoadContract {
    interface LoginModel extends BaseContract.BaseModel {


        Observable<ResponseData<User>> load(String username, String password);


    }
    interface quitModel{
        Observable<ResponseData<User>> quit();
    }
    interface RegisterModel extends  BaseContract.BaseModel{
        Observable<ResponseData<User>> register( String username,  String password,
                                                 String repassword );

    }
    interface RegisterView extends BaseContract.BaseView{
           void registerSu();
           void registerFail(String s);

    }
    interface LoginView extends BaseContract.BaseView{
        void loadSu();
        void loadFail(String s);
    }
    interface RegisterPresenter extends BaseContract.BasePresenter {

        void register( String username,  String password,
                                                 String repassword );


    }
    interface LoginPresenter extends BaseContract.BasePresenter{
        void  load(String username, String password);
    }
}
