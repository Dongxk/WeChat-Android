package com.example.dongxiangkun.wechat_android.Message;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.dongxiangkun.wechat_android.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


public class MessageFragment extends Fragment {


    private static final String TAG = "Message";
    private ListView listView_main_news;
    private List<Map<String, String>> list = null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);

        listView_main_news = (ListView)view.findViewById(R.id.message_list);

        //方法一： 普通赋值
//        list = new ArrayList<Map<String, String>>();
//        for (int i = 0; i < 5; i++) {
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("userphoto", String.valueOf(R.mipmap.ic_launcher));
//            map.put("time",      "20181127_"  + i);
//            map.put("username",  "dongxk_"  + i);
//            map.put("password",  "123456_"  + i);
//            list.add(map);
//        }
//        Log.i(TAG, "==" + list.toString());
//        SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.fragment_message_item,
//                new String[]{"userphoto", "time", "username", "password"},
//                new int[]{R.id.message_friendsPhoto, R.id.message_time, R.id.message_friendsName, R.id.message_mess});
//        listView_main_news.setAdapter(adapter);


        //方法二： 读取指定目录下的所有TXT文件的文件内容
        JSONObject jsonObject = new JSONObject();
        String jsonStr = getFileContent("wechat.txt");
        //借助第三方Gson解析数据
        List<Map<String, String>> fileList = new Gson().fromJson(jsonStr,new TypeToken<List<Map<String,String>>>(){}.getType());

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), fileList, R.layout.fragment_message_item,
                new String[]{"userUrl", "date", "title", "message"},
                new int[]{R.id.message_friendsPhoto, R.id.message_time, R.id.message_friendsName, R.id.message_mess});
        listView_main_news.setAdapter(adapter);


        return  view;

    }


    /*
    * 从assets文件读取数据
    * Android中所谓的本地文件  指的是sd卡，也就是手机文件 与iOS是有区别的*/
    public String getFileContent(String fileName) {
        try {
            InputStreamReader inputReader = new InputStreamReader(getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String Result = "";
            while ((line = bufReader.readLine()) != null)
                Result += line;
            return Result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
