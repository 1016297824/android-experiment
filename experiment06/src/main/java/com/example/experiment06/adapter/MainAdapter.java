package com.example.experiment06.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.experiment06.R;
import com.example.experiment06.entity.News;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder>{

    private static final String TAG = "MainAdapter";
    private List<News> news;

    public MainAdapter(List<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Log.i(TAG,"onCreateViewHolder");

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_news,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Log.i(TAG,"onBindViewHolder:"+i+"/"+news.get(i).title);

        myViewHolder.title.setText(news.get(i).title);
        myViewHolder.match.setText(news.get(i).match);
        myViewHolder.pic.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG,"getItemCount:"+news.size());
        return news.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView match;
        ImageView pic;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            match=itemView.findViewById(R.id.news_match);
            pic=itemView.findViewById(R.id.news_pic);
        }
    }
}
