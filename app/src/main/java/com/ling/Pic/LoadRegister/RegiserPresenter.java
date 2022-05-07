package com.ling.Pic.LoadRegister;

import com.ling.Pic.Contrct.RegisterLoadContract;
import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.bean.User;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RegiserPresenter implements RegisterLoadContract.RegisterPresenter{
    private RegisterLoadContract.RegisterModel registerModel;
    private RegisterLoadContract.RegisterView registerView;

    public RegiserPresenter(RegisterLoadContract.RegisterModel registerModel, RegisterLoadContract.RegisterView registerView) {
        this.registerModel = registerModel;
        this.registerView = registerView;
    }

    @Override
    public void dispose() {
        if(registerView != null)
            registerView = null;
    }

    @Override
    public void register(String username, String password, String repassword) {
        registerModel.register(username,password,repassword).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseData<User>>() {
            @Override
            public void accept(ResponseData<User> userResponseData) throws Throwable {
                if(userResponseData.getErrorCode() != 0)
                    registerView.registerFail(userResponseData.getErrorMsg());
                else
                    registerView.registerSu();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                    registerView.onError();
            }
        });
    }

}
