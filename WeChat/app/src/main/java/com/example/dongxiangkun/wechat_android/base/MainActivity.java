package com.example.dongxiangkun.wechat_android.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.dongxiangkun.wechat_android.module.contact.ContactFragment;
import com.example.dongxiangkun.wechat_android.module.discover.DiscoverFragment;
import com.example.dongxiangkun.wechat_android.module.message.MessageFragment;
import com.example.dongxiangkun.wechat_android.module.mine.MineFragment;
import com.example.dongxiangkun.wechat_android.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ContactFragment contactFragment;
    private MessageFragment messageFragment;
    private DiscoverFragment discoverFragment;
    private MineFragment mineFragment;
    private NavigationBar navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

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

        navigationBar = findViewById(R.id.navigationbar);
        navigationBar.init("微信", false, null);
        navigationBar.rigthTabBar(true, R.mipmap.message_rightitem, new View.OnClickListener() {
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

            navigationBar.setTitle("微信");
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, messageFragment).commit();
           navigationBar.rigthTabBar(true, R.mipmap.message_rightitem, new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
        } else if (v.getId() == R.id.rb_contact) {

            navigationBar.setTitle("通讯录");
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, contactFragment).commit();
            navigationBar.rigthTabBar(true, R.mipmap.contact_rightitem, new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                }
            });

        }else  if (v.getId() == R.id.rb_discover){

            navigationBar.setTitle("发现");
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, discoverFragment).commit();
            navigationBar.rigthTabBar(false, 0, null);
        }else  if (v.getId() == R.id.rb_mine){

            navigationBar.setTitle("我");
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, mineFragment).commit();
            navigationBar.rigthTabBar(false, 0, null);
        }
    }

}
