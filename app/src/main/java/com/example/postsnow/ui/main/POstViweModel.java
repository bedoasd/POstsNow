package com.example.postsnow.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.postsnow.data.PostInteface;
import com.example.postsnow.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class POstViweModel extends ViewModel {
         MutableLiveData<List<PostsModel>> mutableLiveData=new MutableLiveData<>();
         MutableLiveData<String> posts = new MutableLiveData<>();



    public void getPosts(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostInteface postInteface=retrofit.create(PostInteface.class);
        Call<List<PostsModel>> call=postInteface.getPosts();
        call.enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                posts.setValue("Error");
            }
        });
    }
}
