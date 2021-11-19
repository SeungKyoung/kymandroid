package com.example.ex02_gsontogson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import Atask.GsonAtask;
import dto.TestDTO;

public class GsonDto extends AppCompatActivity {
    EditText tv_arr1 , tv_arr2;
    int[] int_etids = {
            R.id.edt_text1,
            R.id.edt_text2,
            R.id.edt_text3
            //필요하면 더 추가하면됨

    };

    EditText[] arr_et = new EditText[int_etids.length];
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dto_gson);
        for (int i = 0 ; i<arr_et.length; i++){
            arr_et[i] = findViewById(int_etids[i]) ;
        }
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] params = new String[ arr_et.length] ;
                TestDTO dto = new TestDTO(arr_et[0].getText()+"" ,
                        arr_et[1].getText()+"" ,
                        arr_et[2].getText()+""
                        );
                GsonAtask gsonAtask = new GsonAtask(dto);
                try {
                    dto = (TestDTO)  gsonAtask.execute().get();
                    arr_et[0].setText(dto.getField1());
                    arr_et[1].setText(dto.getField2());
                    arr_et[2].setText(dto.getField3());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}