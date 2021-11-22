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
import dto.TestDTO;

public class GsonDto extends AppCompatActivity {


    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dto_gson);
        EditText[] arr_et = {
                findViewById(R.id.edt_text1),
                findViewById(R.id.edt_text2),
                findViewById(R.id.edt_text3)
        };
        TextView[] arr_tv = {
                findViewById(R.id.tv_text1),
                findViewById(R.id.tv_text2),
                findViewById(R.id.tv_text3)
        };
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestDTO dto = new TestDTO(arr_et[0].getText()+"" ,
                        arr_et[1].getText()+"" ,
                        arr_et[2].getText()+""
                        );
                GsonAtask gsonAtask = new GsonAtask(dto);
                try {
                    dto = (TestDTO)  gsonAtask.execute().get();
                    arr_tv[0].setText(dto.getField1());
                    arr_tv[1].setText(dto.getField2());
                    arr_tv[2].setText(dto.getField3());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        findViewById(R.id.to_act2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GsonDto.this,GsonList.class);
                startActivity(intent);
            }
        });
    }
}