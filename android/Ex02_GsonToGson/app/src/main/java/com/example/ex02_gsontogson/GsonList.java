package com.example.ex02_gsontogson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import Atask.GsonAtask;

public class GsonList extends AppCompatActivity implements View.OnClickListener {
EditText edt_tv;
Button btn_Send , btn_to_act2;
TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gson);
//        btn_Send = findViewById(R.id.btn_send);
//        edt_tv = findViewById(R.id.edt_text);
//        tv_text = findViewById(R.id.tv_text);
//        btn_to_act2 = findViewById(R.id.to_act2);
//        btn_Send.setOnClickListener(this);
//        btn_to_act2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
//        if(v.getId() == btn_Send.getId()){
//            GsonAtask gsonAtask = new GsonAtask(edt_tv.getText()+"");
//            try {
//                String sprStr =  gsonAtask.execute().get();
//                if (sprStr != null && sprStr.length() > 0){
//                    tv_text.setText(sprStr);
//                }else{
//                    tv_text.setText("응답없음");
//                }
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }else if(v.getId() == btn_to_act2.getId()){
//            Intent intent = new Intent(this, GsonDto.class);
//            startActivity(intent);
//        }
    }
}