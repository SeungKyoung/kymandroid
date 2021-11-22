package Atask;


import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import common.Common;
import dto.TestDTO;

public class GsonAtask extends AsyncTask<Object, Object, Object> {

    private TestDTO dto;
    private ArrayList<TestDTO> list;
    private InputStream is ;
    public GsonAtask( TestDTO dto) {
        this.dto = dto;
    }

    public GsonAtask(ArrayList<TestDTO> list){
        this.list = list;
    }

    @Override
    protected Object doInBackground(Object... objects) {
        if (dto != null) {
            TestDTO dtoa = null;
            try {
                Common common = new Common("spr_gson");
                is = common.sendSpring(dto);
                Gson gson = new Gson();

                dtoa = gson.fromJson(new InputStreamReader(is), TestDTO.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return dtoa;
        } else {
            ArrayList<TestDTO> arrlist = new ArrayList<>();
            try {
                Common common = new Common("spr_gsonlist");
                is = common.sendSpring(list);
                Gson gson = new Gson();
                
                list = gson.fromJson(new InputStreamReader(is), new TypeToken<List<TestDTO>>(){}.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return list;
        }
    }
}
