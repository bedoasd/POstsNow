package com.example.postsnow.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postsnow.R;
import com.example.postsnow.pojo.PostsModel;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<PostsModel> moviesList = new ArrayList<>();



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleTV.setText(moviesList.get(position).getTitle());
        holder.userTV.setText(moviesList.get(position).getUserId()+"");
        holder.bodyTV.setText(moviesList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setList(List<PostsModel>modelList){
        this.moviesList=modelList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, userTV, bodyTV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.titleTV);
            userTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);


        }
    }
}
