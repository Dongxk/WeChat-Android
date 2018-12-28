package com.example.dongxiangkun.wechat_android.module.discover;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dongxiangkun.wechat_android.R;
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

public class LookAdapter extends BaseAdapter {


    private List<LookModel> dataList;
    private Context lContext;

    public LookAdapter(Context context) {

        dataList = new ArrayList<LookModel>();
       lContext = context;
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
                Toast.makeText(lContext, "网络错误", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                JsonObject jsonObject = new JsonParser().parse(response.body().string()).getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("T1348649079062");
                Gson gson = new Gson();
                for (JsonElement jsonModel : jsonArray){
                    LookModel lookModel = gson.fromJson(jsonModel, new TypeToken<LookModel>(){}.getType());
                    dataList.add(lookModel);
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getCount() {

        return dataList.size();
    }

    @Override
    public Object getItem(int i) {

        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View lookView = View.inflate(lContext, R.layout.activity_discover_look_adapter_item, null);


        ImageView ivImage     = viewGroup.findViewById(R.id.lookadapter_image);  //imgsrc
        TextView  tvTitle     = viewGroup.findViewById(R.id.lookadapter_title); //title
        TextView  tvTag       = viewGroup.findViewById(R.id.lookadapter_tag);   //source
        TextView  tvNumber    = viewGroup.findViewById(R.id.lookadapter_number);  //replyCount

        tvTitle.setText(dataList.get(i).getTitle());
        tvTag.setText(dataList.get(i).getSource());
        tvNumber.setText(dataList.get(i).getReplyCount());
        Glide.with(lContext).load(dataList.get(i).getImgsrc()).into(ivImage);

        return lookView;
    }
}
