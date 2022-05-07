package com.ling.Pic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuCompat;
import androidx.core.view.MenuItemCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationBarView;
import com.ling.Pic.RetrofitService.heatSearch;
import com.ling.Pic.RetrofitUtil.RetrofitWarp;
import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.bean.heatSerach;
import com.ling.Pic.databinding.ActivityMainBinding;
import com.ling.Pic.ui.SettingActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Toolbar toolbar;
    private TextView textView;
    private List<heatSerach> heatSeraches = null;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@androidx.annotation.NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = binding.mainToolbar;
        textView = binding.searchBar;
        setSupportActionBar(toolbar);
        init();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);



    }


    @Override
    protected void onStart() {
        super.onStart();
        RetrofitWarp.GsonRetro().create(heatSearch.class).getHeatSearch().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseData<List<heatSerach>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseData<List<heatSerach>> listResponseData) {
                        heatSeraches = listResponseData.getData();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                        showbar();
                    }
                });

    }

    private void init() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("wang","clickTextView");
                toolbar.setVisibility(View.INVISIBLE);
                binding.navView.setVisibility(View.INVISIBLE);
                Bundle bundle = new Bundle();
                bundle.putString("hotKey",textView.getHint().toString());

                NavController navController  = Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment_activity_main);
                navController.navigate(R.id.searchFragment,bundle);

            }
        });
    }

    private void showbar() {

        Observable<heatSerach> heatSerachObservable = Observable.fromIterable(heatSeraches);
        Observable<Long> longObservable = Observable.interval(0,20000, TimeUnit.MILLISECONDS);
        Observable.interval(0,200,TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Throwable {
                        Observable.zip(heatSerachObservable, longObservable, new BiFunction<heatSerach, Long, heatSerach>() {
                            @Override
                            public heatSerach apply(heatSerach heatSerach, Long aLong) throws Throwable {
                                return heatSerach;
                            }
                        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<heatSerach>() {
                            @Override
                            public void accept(heatSerach heatSerach) throws Throwable {

                                textView.setHint(heatSerach.getName());

                            }
                        }).subscribe();
                    }
                });

        }


}