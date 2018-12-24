package com.example.dongxiangkun.wechat_android.base;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dongxiangkun.wechat_android.R;

public class NavigationBar extends FrameLayout {


    private TextView tvTitle;
    private ImageView leftImage;
    private ImageView rightImage;

    public NavigationBar(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public NavigationBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public NavigationBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }



    private void initView(Context context) {

        View view = inflate(context, R.layout.actionbarlayout, this);
        tvTitle    = view.findViewById(R.id.navigationbar_title);
        leftImage  = view.findViewById(R.id.navigationbar_leftImage);
        rightImage = view.findViewById(R.id.navigationbar_rightImage);
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
