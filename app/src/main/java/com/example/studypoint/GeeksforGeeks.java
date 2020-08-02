package com.example.studypoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GeeksforGeeks extends AppCompatActivity {
    WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geeksfor_geeks);
        mywebview=(WebView)findViewById(R.id.geeksforgeeks);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebview.loadUrl("https://www.geeksforgeeks.org/");
        mywebview.setWebViewClient(new mywebviewclient());
    }
    private class mywebviewclient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mywebview.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mywebview.canGoBack()) {
            mywebview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

