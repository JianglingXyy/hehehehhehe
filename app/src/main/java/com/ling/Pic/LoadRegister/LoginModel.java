package com.ling.Pic.LoadRegister;

import com.ling.Pic.Contrct.BaseContract;
import com.ling.Pic.Contrct.RegisterLoadContract;
import com.ling.Pic.RetrofitService.LoadRegister;
import com.ling.Pic.RetrofitUtil.RetrofitWarp;
import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.bean.User;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.internal.Util;

public class LoginModel implements RegisterLoadContract.LoginModel{
    private   LoadRegister loadRegister;

    public LoginModel() {
        this.loadRegister = RetrofitWarp.GsonRetro().create(LoadRegister.class);
    }

    @Override
    public Observable<ResponseData<User>> load(String username, String password) {
        return loadRegister.load(username,password);
    }
}
