package com.example.ex02_gsontogson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import Atask.GsonAtask;
import dto.TestDTO;

public class GsonList extends AppCompatActivity {

Button btn_Send2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gson);
        EditText[] arr_et = {
                findViewById(R.id.et_arr1),
                findViewById(R.id.et_arr2),
                findViewById(R.id.et_arr3)
        };
        TextView[] arr_tv = {
                findViewById(R.id.tv_arr1),
                findViewById(R.id.tv_arr2),
                findViewById(R.id.tv_arr3)
        };
        findViewById(R.id.btn_send2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<TestDTO> list = new ArrayList<>();
                for (int i = 0 ; i < 5 ; i ++){
                    list.add(
                            new TestDTO(arr_et[0].getText() + "" + (i+1)  ,
                                    arr_et[1].getText()  + "" +  (i+1)  ,
                                    arr_et[2].getText()  + "" +  (i+1)   )
                    );
                }


                GsonAtask gsonAtask = new GsonAtask(list);
                try {
                  list = (ArrayList<TestDTO>) gsonAtask.execute().get();
                    for (int i = 0 ; i <list.size(); i++) {
                        if (arr_tv.length-1 < i){
                            break;
                        }
                        arr_tv[i].append(list.get(i).getField1());
                        arr_tv[i].append(  " -" + list.get(i).getField2());
                        arr_tv[i].append(" -"  + list.get(i).getField3());

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