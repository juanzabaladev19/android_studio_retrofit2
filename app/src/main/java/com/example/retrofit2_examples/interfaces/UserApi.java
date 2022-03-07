package com.example.retrofit2_examples.interfaces;

import com.example.retrofit2_examples.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {

    @GET("api/users/{id}")
    Call<User> singleUser(@Path("id") String id);
}
