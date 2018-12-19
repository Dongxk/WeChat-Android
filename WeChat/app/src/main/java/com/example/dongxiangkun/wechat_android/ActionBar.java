package com.example.dongxiangkun.wechat_android;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ActionBar extends FrameLayout {


    private TextView tvTitle;
    private ImageView leftImage;
    private ImageView rightImage;

    public ActionBar(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public ActionBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ActionBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }



    private void initView(Context context) {

        View view = inflate(context, R.layout.actionbarlayout, this);
        tvTitle = view.findViewById(R.id.tv_title);
        leftImage = view.findViewById(R.id.tabBar_left);
        rightImage = view.findViewById(R.id.tabBar_right);
    }


    public void setTitle(String title) {
        tvTitle.setText(title);
    }


    public void init(String title, boolean isLeftVisiable, OnClickListener leftListener){

        tvTitle.setText(title);
        if (isLeftVisiable){
            leftImage.setVisibility(VISIBLE);
            leftImage.setOnClickListener(leftListener);
        }else {
            leftImage.setVisibility(INVISIBLE);
        }

    }

//    public void setRightImage(Integer image) {
//
//        rightImage.setBackgroundResource(image);
//    }


    public void rigthTabBar(boolean isRightVisiable, Integer image,  OnClickListener rightListener){

        rightImage.setBackgroundResource(image);
        if (isRightVisiable){
            rightImage.setVisibility(VISIBLE);
            rightImage.setOnClickListener(rightListener);
        }else {
            rightImage.setVisibility(INVISIBLE);
        }
    }
}
