package com.ling.Pic.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.ling.Pic.CommonAdapter;
import com.ling.Pic.R;
import com.ling.Pic.RetrofitService.search;
import com.ling.Pic.RetrofitUtil.RetrofitWarp;
import com.ling.Pic.base.ViewHolder;
import com.ling.Pic.bean.Article;
import com.ling.Pic.bean.Datas;
import com.ling.Pic.bean.ResponseData;
import com.ling.Pic.databinding.FragmentSearchBinding;
import com.ling.Pic.databinding.FragmentShowBinding;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentSearchBinding binding;
    private RecyclerView recyclerView;
    private CommonAdapter<Article> articleCommonAdapter;
    private List<Article> list;
    private LinearLayoutManager linearLayoutManager;
    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

   private void query(String s) {
       Log.d("wang","query");
       search search = RetrofitWarp.GsonRetro().create(com.ling.Pic.RetrofitService.search.class);
       search.searchArticle(s).subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<ResponseData<Datas<List<Article>>>>() {
                   @Override
                   public void onSubscribe(@NonNull Disposable d) {

                   }

                   @Override
                   public void onNext(@NonNull ResponseData<Datas<List<Article>>> datasResponseData) {
                        list = datasResponseData.getData().getDatas();
                   }

                   @Override
                   public void onError(@NonNull Throwable e) {

                   }

                   @Override
                   public void onComplete() {
                       Log.d("wang", String.valueOf(list.size()));
                        articleCommonAdapter = new CommonAdapter<Article>(getContext(),
                                R.layout.search_items,list) {
                            @Override
                            protected void convert(ViewHolder holder, Article article, int position) {
                                holder.setText(R.id.search_item,article.getTitle());
                                holder.setOnClickListener(R.id.search_item, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                       /* NavController navController = NavHostFragment.findNavController(getParentFragment());
                                        Bundle bundle = new Bundle();
                                        bundle.putString("URL",article.getLink());*/
                                        Intent intent = new Intent(getActivity(),showActivity.class);
                                        intent.putExtra("URL",article.getLink());
                                        startActivity(intent);
                                       // navController.navigate(R.id.showFragment,bundle);
                                    }
                                });
                            }
                        };
                        recyclerView.setAdapter(articleCommonAdapter);

                   }
               });
   }
    @Override
    public void onStart() {
        super.onStart();
        binding.search1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                query(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                query(newText);
                return false;
            }
        });
        binding.search1.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("wang","onclick");
                binding.search1.requestFocus();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       binding = FragmentSearchBinding.inflate(getLayoutInflater());
       recyclerView = binding.tmps;
       binding.back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               NavController navController = NavHostFragment.findNavController(getParentFragment());
               getActivity().findViewById(R.id.mainToolbar).setVisibility(View.VISIBLE);
               getActivity().findViewById(R.id.nav_view).setVisibility(View.VISIBLE);
               navController.navigate(R.id.navigation_home);
           }
       });
       linearLayoutManager = new LinearLayoutManager(getContext());
       recyclerView.setLayoutManager(linearLayoutManager);
       binding.search1.requestFocus();
       String s = getArguments().getString("hotKey");
       if(s != null)
       binding.search1.setQuery(s,false);
       return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}