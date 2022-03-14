package com.example.retrofit2_examples.interfaces;

import com.example.retrofit2_examples.models.Test;
import com.example.retrofit2_examples.models.User;
import com.example.retrofit2_examples.models.UserRequest;
import com.example.retrofit2_examples.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {

    @GET("api/users/{id}")
    Call<User> singleUser(@Path("id") String id);

    @GET("api")
    Call<Test> testEndpoint();

    /*@GET("Login") //i.e https://api.demo.com/Search?
    Call<Products> getUserDetails(@Query("email") String emailID, @Query("password") String password);*/
    //Call<Results> call = service.getUserDetails("abc@gmail.com", "Password@123");

    // is necesary to create a model to send and for response
    /*@POST("post")
    Call<Book> addBook(@Body Book book);*/

    @POST("api/users")
    Call<UserResponse> createUser(@Body UserRequest userRequest);
}
