package com.ling.Pic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ling.Pic.Contrct.BaseContract;

public abstract  class BaseActivity
        extends AppCompatActivity  implements BaseContract.BaseView {
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }
   protected  abstract  void initClick();
}
