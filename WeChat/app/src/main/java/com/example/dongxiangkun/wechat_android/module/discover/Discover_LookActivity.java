package com.example.dongxiangkun.wechat_android.module.discover;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.dongxiangkun.wechat_android.R;
import com.example.dongxiangkun.wechat_android.base.NavigationBar;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Discover_LookActivity extends AppCompatActivity {

    private ListView listView;
    private NavigationBar navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_look);

        navigation = findViewById(R.id.discover_look_Navigation);
        navigation.init("看一看", true, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        navigation.setLeftImage(R.mipmap.back_icon);


        listView = findViewById(R.id.discover_look_listview);
        LookAdapter lookAdapter = new LookAdapter(this);
        listView.setAdapter(lookAdapter);
    }
}
