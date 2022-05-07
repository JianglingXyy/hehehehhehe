package com.ling.Pic.LoadRegister;

import com.ling.Pic.Contrct.RegisterLoadContract;
import com.ling.Pic.RetrofitService.LoadRegister;
import com.ling.Pic.RetrofitUtil.RetrofitWarp;
import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.bean.User;

import io.reactivex.rxjava3.core.Observable;

public class RegisterModel implements RegisterLoadContract.RegisterModel {
    private LoadRegister loadRegister;

    public RegisterModel() {
        loadRegister = RetrofitWarp.GsonRetro().create(LoadRegister.class);
    }


    @Override
    public Observable<ResponseData<User>> register(String username, String password, String repassword) {
        return  loadRegister.register(username,password,repassword);
    }
}
