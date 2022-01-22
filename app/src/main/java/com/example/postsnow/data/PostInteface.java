package com.example.postsnow.data;

import com.example.postsnow.pojo.PostsModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInteface {

    @GET("posts")
    Observable<List<PostsModel>> getPosts();
}
