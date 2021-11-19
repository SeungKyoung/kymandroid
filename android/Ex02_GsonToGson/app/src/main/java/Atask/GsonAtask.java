package Atask;


import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.google.gson.Gson;

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

import common.Common;
import dto.TestDTO;

public class GsonAtask extends AsyncTask<Object, Object, Object> {

    private TestDTO dto;
    private InputStream is ;
    public GsonAtask( TestDTO dto) {
        this.dto = dto;
    }


    @Override
    protected Object doInBackground(Object... objects) {
        TestDTO dtoa = null ;
        try {
            Common common = new Common("spr_gson");
            is = common.sendSpring(dto);
            Gson gson = new Gson();

            dtoa =  gson.fromJson(new InputStreamReader(is),  TestDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  dtoa;
    }
}
