package common;

import android.net.http.AndroidHttpClient;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.InputStream;

public class Common {
    HttpClient httpClient;
    HttpPost httpPost;
    HttpResponse httpResponse;
    HttpEntity httpEntity;
    MultipartEntityBuilder builder;

    String   param ;
    String[] params;
    InputStream inputStream;
    final static String HTTPIP = "http://192.168.0.176";
    final static String SPRPATH = "/android/";
    private String postURL ;


    public Common(String mapping){
        postURL = HTTPIP + SPRPATH +mapping ;
        // MultipartEntityBuild 생성
        builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
    }

    public InputStream sendSpring() {
        initHttp();
        return inputStream;
    }

    public InputStream sendSpring(String param) {
        initParam("param" , param);
        initHttp();
        return inputStream;
    }

    public void initHttp(){
        try {

            httpClient = AndroidHttpClient.newInstance("Android");
            httpPost = new HttpPost(postURL);
            httpPost.setEntity(builder.build());
            inputStream = httpClient.execute(httpPost).getEntity().getContent();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpEntity != null) httpEntity = null;
            if (httpResponse != null)  httpResponse = null;
            if (httpPost != null) httpPost = null;
            if (httpClient != null) httpClient = null;
        }

    }

    public void initParam(String key , String value){
        builder.addTextBody(key, value, ContentType.create("Multipart/related", "UTF-8"));
    }



    public void setMapping(String mapping){
        postURL = HTTPIP + SPRPATH +mapping ;
    }

}
