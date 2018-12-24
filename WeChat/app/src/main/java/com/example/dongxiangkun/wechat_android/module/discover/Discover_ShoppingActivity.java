package com.example.dongxiangkun.wechat_android.module.discover;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.dongxiangkun.wechat_android.base.NavigationBar;
import com.example.dongxiangkun.wechat_android.R;

public class Discover_ShoppingActivity extends AppCompatActivity {


    private WebView webView;
    private ProgressBar progressBar;
    private WebViewClient webViewClient;
    private WebChromeClient webChromeClient;
    private KeyEvent event;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_discover_shopping);

        webView = findViewById(R.id.shopping_webview);
        NavigationBar navigationBar = findViewById(R.id.shopping_actionBar);
        navigationBar.init("京东购物", false, null);

        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();
        //允许使用js
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //支持屏幕缩放
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件


        webView.loadUrl("https://www.jianshu.com/u/524c283ebbff");

//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jianshu.com/u/524c283ebbff"));
//        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放资源
        webView.destroy();
        webView = null;
    }


    private class Url {
    }
}
