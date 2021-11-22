# kymandroid
# Android <-> Spring 간 데이터 전송 참고용 

## 1.Ex01_SendString
<details>
<summary>환경설정 참조</summary>
<div markdown="1">
- String , String[] 로 Spring으로 전송하고 결과 받기
  -  buuld.gradle에서 꼭 추가!
-Spring => String_Controller. 참조

```sh
android{
     useLibrary 'org.apache.http.legacy'
     }
dependencies{  implementation group: 'org.apache.httpcomponents',
     /* 안드로이드와 통신할수 있는 버전 가져오기  */
    implementation group: 'org.apache.httpcomponents', name: 'httpclient-android', version: '4.3.5.1'
    implementation('org.apache.httpcomponents:httpmime:4.3') {
        exclude module: "httpclient"
    }
// https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation group: 'com.google.code.gson', name: 'gson', version: '2.8.5'
}

```
  -  AndroidManifest에서 꼭 추가!
```sh
   <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<application>에 추가  
        android:usesCleartextTraffic="true"
        <uses-library
            android:name="org.apache.http.legacy"
            android:required="false" />


```

</div>
</details>

  
## 1.Ex02_GsonToGson
<details>
<summary>중요 코드 </summary>
<div markdown="1">
- DTO , LIST형태로 데이터 주고받기

```sh
  android
  -GsonAtak.java 파일
     dtoa =  gson.fromJson(new InputStreamReader(is),  TestDTO.class);
      InputStream으로 리턴 받고 리턴받은 InputStream을 다시 원하는 형태의 DTO로 만들기↑
  
   list = gson.fromJson(new InputStreamReader(is), new TypeToken<List<TestDTO>>(){}.getType());
        InputStream으로 리턴 받고 리턴받은 InputStream을 다시 원하는 형태의 LIST 만들기↑
```
```sh
  Spring
  -Gson_Controller.java 파일
  맵핑(spr_gson)
   getParameter로 DTO를 받은 후 원하는 형태으 DTO로 만들기
    String aa =  req.getParameter("dto");
		TestDTO fromDTO =	gson.fromJson(aa,TestDTO.class );
  
  
  
```




</div>
</details>
  
  
  
