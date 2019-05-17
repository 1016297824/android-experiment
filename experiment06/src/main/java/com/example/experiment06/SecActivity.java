package com.example.experiment06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.experiment06.adapter.SecAdapter;
import com.example.experiment06.entity.News;

import java.util.ArrayList;
import java.util.List;

public class SecActivity extends AppCompatActivity {

    private Button button;
    private RecyclerView recyclerView;
    private SecAdapter secAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        recyclerView = findViewById(R.id.act_sec_RecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        secAdapter = new SecAdapter(listNews(), this);
        recyclerView.setAdapter(secAdapter);

        button = findViewById(R.id.act_sec_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<News> listNews() {
        News n1 = new News(1, "阿根廷VS波黑", "小组赛F组 阿根廷VS波黑");
        News n2 = new News(2, "法国VS洪都拉斯", "小组赛E组 法国VS洪都拉斯");
        News n3 = new News(3, "瑞士VS厄瓜多尔", "小组赛E组 瑞士VS厄瓜多尔");
        News n4 = new News(4, "西班牙VS荷兰", "小组赛B组 西班牙VS荷兰");
        List<News> news = new ArrayList<>();
        news.add(n1);
        news.add(n2);
        news.add(n3);
        news.add(n4);
        news.add(n1);
        news.add(n2);
        news.add(n3);
        news.add(n4);
        return news;
    }
}
