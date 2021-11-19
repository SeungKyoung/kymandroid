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

public class SendString extends AsyncTask<String, String, String> {

    String param;

    public SendString(String param) {
        this.param = param;
    }


    @Override
    protected String doInBackground(String... strings) {

            Common common = new Common("spr_str");
            InputStream is = common.sendSpring(param);
            return  rtnString(is);

    }
    public String rtnString(InputStream inputStream)  {
        try{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line + "\n");
        }
            return stringBuilder.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
