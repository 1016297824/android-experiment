package com.example.experiment07.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.experiment07.R;
import com.example.experiment07.entity.News;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> implements MyCallback.AdapterCallback{
    private static final String TAG = "MainAdapter";
    private List<News> news;
    public MainAdapter(List<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_news,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(news.get(position).title);
        holder.match.setText(news.get(position).match);
        holder.pic.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public void remove(int position) {
        news.remove(position);
        notifyItemRemoved(position);
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
