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
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, messageFragment).commit();
        } else if (v.getId() == R.id.rb_contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, contactFragment).commit();
        }else  if (v.getId() == R.id.rb_discover){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, discoverFragment).commit();
        }else  if (v.getId() == R.id.rb_mine){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, mineFragment).commit();
        }
    }

}
