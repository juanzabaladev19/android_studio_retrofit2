package com.example.retrofit2_examples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofit2_examples.interfaces.UserApi;
import com.example.retrofit2_examples.models.Data;
import com.example.retrofit2_examples.models.Test;
import com.example.retrofit2_examples.models.User;
import com.example.retrofit2_examples.models.UserRequest;
import com.example.retrofit2_examples.models.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getUser("1");
        //testingGetRequest();
        createUser();
    }

    public void getUser(String codigo){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://reqres.in").addConverterFactory(GsonConverterFactory.create()).build();


        UserApi userApi = retrofit.create(UserApi.class);
        Call<User> call = userApi.singleUser("1");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                try {
                    if(response.isSuccessful()){
                        User user = response.body();
                        Data data = user.getData();
                        Log.d("data", data.getEmail());
                    }
                }
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void testingGetRequest(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.20.41/backend_bancolombia_app_clone/").addConverterFactory(GsonConverterFactory.create()).build();;
        UserApi userApi = retrofit.create(UserApi.class);
        Call<Test> call = userApi.testEndpoint();
        call.enqueue(new Callback<Test>() {
            @Override
            public void onResponse(Call<Test> call, Response<Test> response) {
                try{
                    if(response.isSuccessful()){
                        Test test = response.body();
                        Toast.makeText(MainActivity.this, test.getData(), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Test> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void createUser(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://reqres.in/").addConverterFactory(GsonConverterFactory.create()).build();;
        UserApi userApi = retrofit.create(UserApi.class);
        UserRequest userRequest = new UserRequest("morpheus", "leader");
        Call<UserResponse> user = userApi.createUser(userRequest);
        user.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                try{
                    if(response.isSuccessful()){
                        UserResponse request = response.body();
                        Toast.makeText(MainActivity.this, request.getCreatedAt(), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}