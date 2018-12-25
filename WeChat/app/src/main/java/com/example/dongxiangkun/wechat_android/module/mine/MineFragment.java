package com.example.dongxiangkun.wechat_android.module.mine;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dongxiangkun.wechat_android.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {


    public MineFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        return  view;
    }

}
