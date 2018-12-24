package com.example.dongxiangkun.wechat_android.module.discover;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dongxiangkun.wechat_android.R;

import java.util.List;
import java.util.Map;

public class LookAdapter extends BaseAdapter {


    private List<Map<String, String>> dataList;
    private Context context;

    public LookAdapter(List<Map<String, String>> list) {

        dataList = list;
    }

    public void getData(){

        String url  = "http://c.m.163.com/nc/article/list/T1348649079062/0-10.html";


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

        View lookView = View.inflate(context, R.layout.activity_discover_look_adapter_item, null);

        return lookView;
    }
}
