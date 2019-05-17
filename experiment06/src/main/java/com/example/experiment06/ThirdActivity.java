package com.example.experiment06;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.experiment06.adapter.ThirdAdapter;
import com.example.experiment06.entity.News;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";
    private RecyclerView recyclerView;
    private ThirdAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<News> news = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        swipeRefreshLayout = findViewById(R.id.act_third_swipe);
        recyclerView = findViewById(R.id.act_third_RecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        News n1 = new News(1, "阿根廷VS波黑"+(news.size()+1), "小组赛F组 阿根廷VS波黑");

        news.add(n1);
        adapter = new ThirdAdapter(news);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(() -> {
                    swipeRefreshLayout.setRefreshing(false);
                    news.add(new News(1,"阿根廷VS波黑"+(news.size()+1), "小组赛F组 阿根廷VS波黑"));
                    Log.i(TAG,"onRefresh:"+news.size());
                    adapter.notifyDataSetChanged();
                },500);
            }
        });
    }
}
