package com.ling.Pic.LoadRegister;

import com.ling.Pic.Contrct.BaseContract;
import com.ling.Pic.Contrct.RegisterLoadContract;
import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.bean.User;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginPresenter implements RegisterLoadContract.LoginPresenter {

    private RegisterLoadContract.LoginView loginView;
    private final RegisterLoadContract.LoginModel loginModel;

    public LoginPresenter(RegisterLoadContract.LoginView loginView, RegisterLoadContract.LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    @Override
    public void dispose() {
        if(loginView != null)
            loginView = null;}

    @Override
    public void load(String username, String password) {
      loginModel.load(username,password).
              subscribeOn(Schedulers.io()).
              observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Consumer<ResponseData<User>>() {
                  @Override
                  public void accept(ResponseData<User> userResponseData) throws Throwable {
                      if(userResponseData.getErrorCode() == 0 ){
                          loginView.loadSu();
                      }
                      else{
                          loginView.loadFail(userResponseData.getErrorMsg());
                      }
                  }
              }, new Consumer<Throwable>() {
                  @Override
                  public void accept(Throwable throwable) throws Throwable {
                      loginView.onError();
                  }
              });
    }


}
