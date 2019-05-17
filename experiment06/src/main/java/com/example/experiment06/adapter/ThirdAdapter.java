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

public class ThirdAdapter extends RecyclerView.Adapter<ThirdAdapter.MyViewHolder> {

    private static final String TAG = "ThirdAdapter";
    private List<News> news;

    public ThirdAdapter(List<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG,"onCreateViewHolder");

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_news,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i(TAG,"onBindViewHolder");

        holder.title.setText(news.get(position).title);
        holder.match.setText(news.get(position).match);
        holder.pic.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG,"getItemCount:"+news.size());
        return news.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView match;
        ImageView pic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            match = itemView.findViewById(R.id.news_match);
            pic = itemView.findViewById(R.id.news_pic);
        }
    }
}
