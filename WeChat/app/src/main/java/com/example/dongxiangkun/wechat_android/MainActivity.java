package com.example.dongxiangkun.wechat_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.dongxiangkun.wechat_android.Contact.ContactFragment;
import com.example.dongxiangkun.wechat_android.Discover.DiscoverFragment;
import com.example.dongxiangkun.wechat_android.Message.MessageFragment;
import com.example.dongxiangkun.wechat_android.Mine.MineFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ContactFragment contactFragment;
    private MessageFragment messageFragment;
    private DiscoverFragment discoverFragment;
    private MineFragment mineFragment;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
//        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);

        bindViews();
        initData();
    }


    private void initData() {
        contactFragment     = new ContactFragment();
        messageFragment     = new MessageFragment();
        discoverFragment    = new DiscoverFragment();
        mineFragment        = new MineFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, messageFragment).commit();
    }

    //UI组件初始化与事件绑定
    private void bindViews() {

        actionBar = findViewById(R.id.navigationbar);
        actionBar.init("微信", false, null);
        actionBar.rigthTabBar(true, R.mipmap.message_rightitem, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        RadioButton rbTab1 = findViewById(R.id.rb_weChat);
        RadioButton rbTab2 = findViewById(R.id.rb_contact);
        RadioButton rbTab3 = findViewById(R.id.rb_discover);
        RadioButton rbTab4 = findViewById(R.id.rb_mine);

        rbTab1.setChecked(true);

        rbTab1.setOnClickListener(this);
        rbTab2.setOnClickListener(this);
        rbTab3.setOnClickListener(this);
        rbTab4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rb_weChat) {

            actionBar.setTitle("微信");
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, messageFragment).commit();
           actionBar.rigthTabBar(true, R.mipmap.message_rightitem, new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
        } else if (v.getId() == R.id.rb_contact) {

            actionBar.setTitle("通讯录");
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, contactFragment).commit();
            actionBar.rigthTabBar(true, R.mipmap.contact_rightitem, new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                }
            });

        }else  if (v.getId() == R.id.rb_discover){

            actionBar.setTitle("发现");
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, discoverFragment).commit();
            actionBar.rigthTabBar(false, 0, null);
        }else  if (v.getId() == R.id.rb_mine){

            actionBar.setTitle("我");
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, mineFragment).commit();
            actionBar.rigthTabBar(false, 0, null);
        }
    }

}
