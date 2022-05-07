package com.ling.Pic.Contrct;

import android.view.View;

/**
 * base MVP
 */
public interface BaseContract  {
    interface BaseModel{

    }
    interface BaseView {
        void showProgress();

        void hideProgress();

        void onError();
    }
    interface BasePresenter {
        void dispose();
    }
}
