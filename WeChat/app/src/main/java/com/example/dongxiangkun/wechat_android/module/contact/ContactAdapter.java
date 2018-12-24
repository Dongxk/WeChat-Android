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

        View view = View.inflate(mContext, R.layout.fregment_contact_item_adapter,null);

        ImageView ivHeadIcon = view.findViewById(R.id.iv_head_icon);
        TextView tvName = view.findViewById(R.id.tv_name);
//        Log.d("xxxxxxxxxx", "getView:  " + mList.get(position).get("photo"));
        Glide.with(mContext).load("http://weixintest.ihk.cn/ihkwx_upload/commentPic/20160503/14622764778932thumbnail.jpg").into(ivHeadIcon);
//        ivHeadIcon.setImageResource(R.mipmap.ic_launcher);
        tvName.setText(mList.get(position).get("userName"));

        return view;
    }
}
