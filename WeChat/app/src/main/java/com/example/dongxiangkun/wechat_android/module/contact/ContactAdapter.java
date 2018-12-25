package com.example.dongxiangkun.wechat_android.module.contact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dongxiangkun.wechat_android.R;

import java.util.List;
import java.util.Map;

public class ContactAdapter extends BaseAdapter {


    private Context mContext;
    private List<Map<String, String>> mList;

    public ContactAdapter(Context context, List<Map<String, String>> list) {
        mContext = context;
        mList = list;
    }


    @Override
    public int getCount() {

        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.fragment_contact_item_adapter,null);
        }


        ImageView ivHeadIcon = convertView.findViewById(R.id.iv_head_icon);
        TextView tvName = convertView.findViewById(R.id.tv_name);

        Glide.with(mContext).load("http://weixintest.ihk.cn/ihkwx_upload/commentPic/20160503/14622764778932thumbnail.jpg").into(ivHeadIcon);
        tvName.setText(mList.get(position).get("userName"));
        return convertView;
    }
}
