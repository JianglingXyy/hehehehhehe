package com.ling.Pic.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.ling.Pic.CommonAdapter;
import com.ling.Pic.R;
import com.ling.Pic.RetrofitService.guangchang;
import com.ling.Pic.RetrofitService.newProject;
import com.ling.Pic.RetrofitUtil.RetrofitWarp;
import com.ling.Pic.base.ViewHolder;
import com.ling.Pic.bean.Article;
import com.ling.Pic.bean.Datas;
import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.databinding.FragmentNotificationsBinding;
import com.ling.Pic.ui.showActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private int refreshTime = 0;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private List<Article> list ;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        recyclerView = binding.recyclerNew;
        refreshLayout = binding.swipeNew;
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getdata();
            }
        });
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void getdata(){
        RetrofitWarp.GsonRetro().create(newProject.class)
                .getNew(refreshTime++)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseData<Datas<List<Article>>>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull ResponseData<Datas<List<Article>>> datasResponseData) {
                        list = datasResponseData.getData().getDatas();
                        Log.d("wang", String.valueOf(list.size()));
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(new CommonAdapter<Article>(
                                getContext(), R.layout.article_item,list
                        ) {
                            @Override
                            protected void convert(ViewHolder holder, Article article, int position) {
                                if(article.getTitle() != null)
                                holder.setText(R.id.titletextview,article.getTitle());
                                holder.setOnClickListener(R.id.holder, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(getActivity(), showActivity.class);
                                        intent.putExtra("URL",article.getLink());
                                        startActivity(intent);
                                    }
                                });
                                holder.setText(R.id.chapter,article.getChapterName());
                                holder.setText(R.id.shareAuthor,article.getShareUser());
                                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                                String s = sdf.format(new Date(article.getShareDate()));
                                holder.setText(R.id.sharetime,s);
                                refreshLayout.setRefreshing(false);
                            }
                        });
                    }
                });
    }
    @Override
    public void onStart() {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
                getdata();
            }
        });
        super.onStart();
    }
}