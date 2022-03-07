package com.example.retrofit2_examples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit2_examples.interfaces.UserApi;
import com.example.retrofit2_examples.models.Data;
import com.example.retrofit2_examples.models.User;

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
        getUser("1");
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
}