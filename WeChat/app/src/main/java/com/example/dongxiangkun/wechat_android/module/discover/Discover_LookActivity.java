package com.example.dongxiangkun.wechat_android.module.discover;

import android.os.Handler;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dongxiangkun.wechat_android.R;
import com.example.dongxiangkun.wechat_android.base.NavigationBar;
import com.example.dongxiangkun.wechat_android.model.LookModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Discover_LookActivity extends AppCompatActivity {

    private ListView listView;
    private NavigationBar navigation;
    private List<LookModel> datalist;
    private LookAdapter lookAdapter;

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

        datalist = new ArrayList<>();

        navigation.setLeftImage(R.mipmap.back_icon);

        listView = findViewById(R.id.discover_look_listview);
        lookAdapter = new LookAdapter(this, datalist);
        listView.setAdapter(lookAdapter);


        getData();
    }

    public void getData(){

        String url  = "http://c.m.163.com/nc/article/list/T1348649079062/0-10.html";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .header("User-Agent", "")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(Discover_LookActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                JsonObject jsonObject = new JsonParser().parse(response.body().string()).getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("T1348649079062");
                Gson gson = new Gson();
                for (JsonElement jsonModel : jsonArray){
                    LookModel lookModel = gson.fromJson(jsonModel, new TypeToken<LookModel>(){}.getType());
                    datalist.add(lookModel);
                }


                new Handler(getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        lookAdapter.notifyDataSetChanged();
                    }
                });

//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        lookAdapter.notifyDataSetChanged();
//                    }
//                });

            }
        });

    }
}
