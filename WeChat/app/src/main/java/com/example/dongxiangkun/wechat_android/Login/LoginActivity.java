package com.example.dongxiangkun.wechat_android.Login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dongxiangkun.wechat_android.MainActivity;
import com.example.dongxiangkun.wechat_android.R;

public class LoginActivity extends AppCompatActivity {


    private EditText userName;
    private EditText passWord;
    private RadioGroup  radioGroup;
    private Button loginBtn;
    private String sex = "男";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //获取输入源
        userName = (EditText)findViewById(R.id.nameEditTest);
        passWord = (EditText)findViewById(R.id.pwdEditTest);

        //radioGroup点击事件
        radioGroup = (RadioGroup)findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                sex = ((RadioButton)findViewById(checkedId)).getText().toString();
            }
        });

        //登录点击事件
        loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Rect r = new Rect();
//                //获取当前界面可视部分
                LoginActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                //获取屏幕的高度
                int screenHeight =  LoginActivity.this.getWindow().getDecorView().getRootView().getHeight();
                //此处就是用来获取键盘的高度的， 在键盘没有弹出的时候 此高度为0 键盘弹出的时候为一个正数
                int heightDifference = screenHeight - r.bottom;
                Log.d("Keyboard Size", "Size: " + heightDifference);

                if(getWindow().getAttributes().softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE){

                    Toast.makeText(LoginActivity.this, "11!", Toast.LENGTH_SHORT).show();

//                    InputMethodManager imManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
//                    imManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                }else {

                    Toast.makeText(LoginActivity.this, "22!", Toast.LENGTH_SHORT).show();

                }

                String userNameStr = userName.getText().toString();
                String passWordStr = passWord.getText().toString();

                if (userNameStr.isEmpty()){
                    Dialog alert = new AlertDialog.Builder(LoginActivity.this).setTitle("提示").setMessage("用户名不可为空").create();
                    alert.show();
                    return;
                }

                if (passWordStr.isEmpty()){
                    Dialog alert = new AlertDialog.Builder(LoginActivity.this).setTitle("提示").setMessage("密码不可为空").create();
                    alert.show();
                    return;
                }

                if (sex.equals("男")){

                    Toast.makeText(LoginActivity.this, "失败!", Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(LoginActivity.this, "成功!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
