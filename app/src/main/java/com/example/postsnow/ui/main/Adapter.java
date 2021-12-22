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
    private Context context;
    private List<PostsModel>modelList=new ArrayList<>();



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.post_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(modelList.get(position).getTitle());
        holder.userid.setText(modelList.get(position).getUserId());
        holder.body.setText(modelList.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void setList(List<PostsModel>modelList){
        this.modelList=modelList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,userid,body;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.titleTV);
            userid=itemView.findViewById(R.id.userIDTV);
            body=itemView.findViewById(R.id.bodyTV);


        }
    }
}
