package com.example.ex03_retrofitapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dto.TestDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {


    private static final String TAG ="aaaa" ;
    private Retrofit mRetrofit;
    private Call<String> testList;
    private RetrofitAPI mRetrofitAPI;
    private Gson mGson = new Gson();

    private ArrayList<TestDTO> list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetroAPI api = new RetroAPI();
                api.initRetrofit(mRetrofit, mRetrofitAPI);
                callSpringList();
            }
        });
    }



    //Retrofit에 파라메터를 추가해서 날림
    //RetrofitAPI Interface참조 !
    void callSpringList() {
        ArrayList<TestDTO> list = new ArrayList<>();
        for (int i = 0 ; i<10 ; i++){
            list.add(new TestDTO("field1" , "field2" , "field3"));
        }
        testList = mRetrofitAPI.getGson_List(mGson.toJson(list));//파라메터를 추가함
        testList.enqueue(mRetrofitCallback);//실제 전송하는 부분
    }


    //결과 받아서 처리하는 부분
    private Callback<String> mRetrofitCallback = new Callback<String>() {
        private static final String TAG = "test";
        @Override
        public void onResponse(Call<String> call, Response<String> response) {
            String result = response.body();
            list=  mGson.fromJson(result, new TypeToken<List<TestDTO>>(){}.getType());
            for (int i = 0 ; i<list.size() ; i++){
                Log.d(TAG, "onResponse: " + list.get(i).getField1());
                Log.d(TAG, "onResponse: " + list.get(i).getField2());
                Log.d(TAG, "onResponse: " + list.get(i).getField3());
            }

        }
        //오류 났을때 출력되는 부분!
        @Override
        public void onFailure(Call<String> call, Throwable t) {
            t.printStackTrace();
        }

    };

}