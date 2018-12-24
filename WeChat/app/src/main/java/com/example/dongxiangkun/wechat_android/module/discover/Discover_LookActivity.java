package com.example.dongxiangkun.wechat_android.module.discover;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dongxiangkun.wechat_android.R;

public class Discover_LookActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_look);

        listView = findViewById(R.id.discover_look_listview);



    }
}
