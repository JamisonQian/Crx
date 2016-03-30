package com.crxjr.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.crxjr.app.http.OkHttpManager;
import com.crxjr.app.http.callback.StringCallback;
import com.crxjr.app.http.cookies.PersistentCookieStore;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin,btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(this);
        PersistentCookieStore cookieStore = new PersistentCookieStore(this);
        Log.i("TAG",cookieStore.getCookies().size()+"");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnInfo:
                getBaseInfo();
                break;
        }
    }

    /**
     * 测试登录
     */
    private void login(){
        String url = "http://p.thedoc.cn/doctor/login/";
        OkHttpManager.post().url(url).addParams("mobile","15000112837").addParams("pwd","123456").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
            }
            @Override
            public void onResponse(String response) {
                Log.i("TAG",response);
            }
        });

    }
    private void getBaseInfo(){
        String url = "http://p.thedoc.cn/doctor/doctorInfo/";
        OkHttpManager.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
            }

            @Override
            public void onResponse(String response) {
                Log.i("TAG",response);

            }
        });
    }
}
