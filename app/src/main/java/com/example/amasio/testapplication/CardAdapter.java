package com.example.amasio.testapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    List<Job> jobItems;
    Job job;


    public CardAdapter(ArrayList<Job> jobs) {
        super();
        jobItems =jobs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        job = jobItems.get(i);
        viewHolder.title.setText(job.getTitle());
        viewHolder.info.setText(job.getMajor() + ", " + job.getLocation());
        //viewHolder.imgThumbnail.setImageResource();
    }

    @Override
    public int getItemCount() {
        return jobItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        //public ImageView imgThumbnail;
        public TextView info;

        public ViewHolder(View itemView) {
            super(itemView);
            title =(TextView)itemView.findViewById(R.id.titleText);
            info = (TextView)itemView.findViewById(R.id.infoText);
        }
    }

    public Job getJob(){
        return job;
    }
}