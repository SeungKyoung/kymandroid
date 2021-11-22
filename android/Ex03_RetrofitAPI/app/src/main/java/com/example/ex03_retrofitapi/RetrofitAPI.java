package com.example.ex03_retrofitapi;

import java.util.ArrayList;

import dto.TestDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {
    //매핑이름 써주면됨
    @POST("spr_gsonlist")
    Call<String> getGson_List(@Query("list")String list  );

}

