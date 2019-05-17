package com.example.experiment06.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.experiment06.R;
import com.example.experiment06.entity.News;

import java.util.List;

public class SecAdapter extends RecyclerView.Adapter<SecAdapter.ViewHolder>{

    private static final String TAG = "SecAdapter";

    private List<News> news;
    private Context context;

    public SecAdapter(List<News> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Log.i(TAG,"onCreateViewHolder");

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_news, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {

        Log.i(TAG,"onCreateViewHolder"+news.get(i).title);

        viewHolder.title.setText(news.get(i).title);
        viewHolder.match.setText(news.get(i).match);
        viewHolder.pic.setImageResource(R.mipmap.ic_launcher);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,news.get(i).title,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i(TAG,"getItemCount:"+news.size());
        return news.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView match;
        public ImageView pic;

        public ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.news_title);
            match = view.findViewById(R.id.news_match);
            pic = view.findViewById(R.id.news_pic);
        }
    }

    public interface OnItemClickListener
    {
        void onItemClick(View view, int position, News news);
    }
}
