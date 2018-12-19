package com.example.dongxiangkun.wechat_android.Discover;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dongxiangkun.wechat_android.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment implements View.OnClickListener {


    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        TextView textView1 = (TextView) view.findViewById(R.id.discover_pengyouquan);
        TextView textView2 = (TextView) view.findViewById(R.id.discover_saoyisao);
        TextView textView3 = (TextView) view.findViewById(R.id.discover_yaoyiyao);
        TextView textView4 = (TextView) view.findViewById(R.id.discover_kanyikan);
        TextView textView5 = (TextView) view.findViewById(R.id.discover_souyisou);
        TextView textView6 = (TextView) view.findViewById(R.id.discover_fujin);
        RelativeLayout relativeLayout7 = view.findViewById(R.id.discover_shopping);
        RelativeLayout relativeLayout8 = view.findViewById(R.id.discover_game);
        TextView textView9 = (TextView) view.findViewById(R.id.discover_xiaochengxu);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);
        relativeLayout7.setOnClickListener(this);
        relativeLayout8.setOnClickListener(this);
        textView9.setOnClickListener(this);



        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.discover_pengyouquan :

                Toast.makeText(getActivity(), "朋友圈", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.discover_saoyisao :

                Toast.makeText(getActivity(), "扫一扫", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.discover_yaoyiyao :

                Toast.makeText(getActivity(), "摇一摇", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.discover_kanyikan :

                Toast.makeText(getActivity(), "看一看", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.discover_souyisou :

                Toast.makeText(getActivity(), "搜一搜", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.discover_fujin :

                Toast.makeText(getActivity(), "附近的人", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.discover_shopping :

                Intent intent = new Intent(getActivity(), Discover_ShoppingActivity.class);
                startActivity(intent);
                break;

            case  R.id.discover_game :

                Toast.makeText(getActivity(), "游戏", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.discover_xiaochengxu :

                Toast.makeText(getActivity(), "小程序", Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }
    }
}
