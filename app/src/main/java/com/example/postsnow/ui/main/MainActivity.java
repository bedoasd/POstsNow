package com.example.postsnow.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.postsnow.R;
import com.example.postsnow.pojo.PostsModel;
import com.example.postsnow.ui.main.Adapter;
import com.example.postsnow.ui.main.POstViweModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    POstViweModel postViewModel;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel=new ViewModelProvider(this).get(POstViweModel.class);
        postViewModel.getPosts();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        final Adapter adapter= new Adapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postViewModel.mutableLiveData.observe(this, new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {
                adapter.setList(postsModels);
            }
        });


    }
}