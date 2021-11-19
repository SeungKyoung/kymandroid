package com.example.ex01_springtoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import Atask.SendString;
import common.Common;

public class MainActivity extends AppCompatActivity {
EditText edt_tv;
Button btn_Send;
TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Send = findViewById(R.id.btn_send);
        edt_tv = findViewById(R.id.edt_text);
        tv_text = findViewById(R.id.tv_text);
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendString sendString = new SendString(edt_tv.getText()+"");
                try {
                  String sprStr =  sendString.execute().get();
                  if (sprStr != null && sprStr.length() > 0){
                      tv_text.setText(sprStr);
                  }else{
                      tv_text.setText("응답없음");
                  }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}