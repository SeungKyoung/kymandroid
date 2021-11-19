package com.example.ex01_springtoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import Atask.SendString;

public class SendArrActivity extends AppCompatActivity {
    EditText tv_arr1 , tv_arr2;
    int[] int_etids = {
            R.id.tv_arr1,
            R.id.tv_arr2
            //필요하면 더 추가하면됨

    };
    EditText[] arr_et = new EditText[int_etids.length];
    Button btn_send2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        for (int i = 0 ; i<arr_et.length; i++){
            arr_et[i] = findViewById(int_etids[i]) ;
        }
        btn_send2 = findViewById(R.id.btn_send2);
        btn_send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] params = new String[ arr_et.length] ;
                for(int i = 0 ; i<arr_et.length; i ++ ){
                    params[i] = arr_et[i].getText()+"";
                }
                SendString sendString = new SendString(params);
                try {
                    String sprStr =  sendString.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}