package com.example.dongxiangkun.wechat_android.Contact;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.dongxiangkun.wechat_android.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact, container, false);


        ListView listView = (ListView)view.findViewById(R.id.contact_listView);


        JSONObject jsonObject = new JSONObject();
        String jsonStr = getFileContent("contact.json");

        final List<Map<String, String>> fileList = new Gson().fromJson(jsonStr,new TypeToken<List<Map<String,String>>>(){}.getType());


//        List list = new ArrayList<Map<String, String>>();
//        for (int i = 0; i < 5; i++) {
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("photo",     "http://s6.cdn.deahu.com/show/lfile/8E9CDE37D4E5AFBFEB9A6FB2CC594187.jpg");
//            map.put("userName",  "dongxk_"  + i);
//            list.add(map);
//        }


        SimpleAdapter adapter  = new SimpleAdapter(getActivity(), fileList, R.layout.fragment_contact_item,
                                new String[]{"photo", "userName"},
                                new int[]{R.id.contact_image, R.id.contact_name});
        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {

                if (view instanceof ImageView){

                    if (data instanceof Bitmap){

                        ImageView iv = (ImageView) view;
                        iv.setImageBitmap((Bitmap) data);

                    }else {

                        ImageView iv = (ImageView) view;

//                        Glide.with(getContext()).load(data).placeholder(R.mipmap.ic_launcher).into(iv);


                        try {
                            URL url = new URL( "http://weixintest.ihk.cn/ihkwx_upload/commentPic/20160519/14636463273461.JPEG");
                            iv.setImageBitmap(BitmapFactory.decodeStream(url.openStream()));

                        } catch (Exception e) {

                            Log.i("e-----------------", "setViewValue: " +e);
                        }


//                    myImageView.setImageURI(Uri.parse(http://example.com/logo.png));


                    }

                    return  true;
                }
                return  false;
            }
        });
        listView.setAdapter(adapter);

        //自定义adapter
//        ContactAdapter contactAdapter = new ContactAdapter(getActivity(), fileList);
//        listView.setAdapter(contactAdapter);

        return view;
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
