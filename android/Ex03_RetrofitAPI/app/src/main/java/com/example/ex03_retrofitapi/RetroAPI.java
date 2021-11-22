package com.example.ex03_retrofitapi;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import dto.TestDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroAPI {




    final static String BASEURL = "http://192.168.0.176/android/";


    //Retrofit객체를 초기화 시킨다.
     void initRetrofit(Retrofit mRetrofit , RetrofitAPI mRetrofitAPI){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASEURL) //base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRetrofitAPI = mRetrofit.create(RetrofitAPI.class);
    }






}
