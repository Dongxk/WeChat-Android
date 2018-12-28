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

    public LookAdapter(Context context, List<LookModel> dataList) {

       lContext = context;
       this.dataList = dataList == null ? new ArrayList<LookModel>() : dataList;

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


        ImageView ivImage     = lookView.findViewById(R.id.lookadapter_image);  //imgsrc
        TextView  tvTitle     = lookView.findViewById(R.id.lookadapter_title); //title
        TextView  tvTag       = lookView.findViewById(R.id.lookadapter_tag);   //source
        TextView  tvNumber    = lookView.findViewById(R.id.lookadapter_number);  //replyCount

        tvTitle.setText(dataList.get(i).getTitle());
        tvTag.setText(dataList.get(i).getSource());
        String numberString = dataList.get(i).getReplyCount() == null ? "0" : dataList.get(i).getReplyCount();
        tvNumber.setText("回帖" + numberString);
        Glide.with(lContext).load(dataList.get(i).getImgsrc()).into(ivImage);
        return lookView;
    }
}
