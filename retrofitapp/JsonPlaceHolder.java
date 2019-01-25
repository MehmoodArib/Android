package com.example.mehmood.retrofitapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolder {
    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId ,
                              @Query("_sort") String sort,
                              @Query("_order") String order);

    @GET("posts/1/comments")
    Call<List<Comment>> getComment();

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int PostId);

    @POST("post")
    Call<Post> createPost(Post post);

}