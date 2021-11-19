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

    private String param;
    private String[] params;
    private InputStream is ;
    public SendString(String param) {
        this.param = param;
    }
    public SendString(String[] params){
        this.params = params;
    }

    @Override
    protected String doInBackground(String... strings) {
        if (param != null){
            Common common = new Common("spr_str");
            is = common.sendSpring(param);
        }else if(params != null){
            Common common = new Common("spr_strs");
            is = common.sendSpring(params);
        }

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
