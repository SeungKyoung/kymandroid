# kymandroid
# Android <-> Spring !

## 1.Ex01_SendString
<details>
<summary>환경설정 참조</summary>
<div markdown="1">
- String , String[] 로 Spring으로 전송하고 결과 받기
  -  buuld.gradle에서 꼭 추가!

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
