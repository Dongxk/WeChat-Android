package com.example.dongxiangkun.wechat_android.module.discover;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.dongxiangkun.wechat_android.base.NavigationBar;
import com.example.dongxiangkun.wechat_android.R;

public class Discover_ShoppingActivity extends AppCompatActivity {


    private NavigationBar navigationBar;
    private WebView webView;
    private ProgressBar progressBar;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_discover_shopping);
        navigationBar = findViewById(R.id.shopping_actionBar);
        navigationBar.setLeftImage(R.mipmap.back_icon);
        progressBar = findViewById(R.id.shopping_progressbar);
        webView = findViewById(R.id.shopping_webview);
        webView.loadUrl("https://www.jianshu.com/u/524c283ebbff");


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


        webView.setWebViewClient(webViewClient);
        webView.setWebChromeClient(webChromeClient);
    }


    //WebViewClient帮助WebView处理各种通知、请求事件
    private WebViewClient webViewClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);
        }


        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

        }

    };

    //WebChromeClient辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度
    private WebChromeClient webChromeClient = new WebChromeClient() {

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {

            AlertDialog.Builder localBuilder = new AlertDialog.Builder(webView.getContext());
            localBuilder.setMessage(message).setPositiveButton("确定", null);
            localBuilder.setCancelable(false);
            localBuilder.create().show();
            result.confirm();
            return true;
        }


        @Override
        public void onReceivedTitle(WebView view, String title) {
            navigationBar.init(title, true, new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }


        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {

            progressBar.setProgress(newProgress);
        }

    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放资源
        webView.destroy();
        webView = null;
    }

}
