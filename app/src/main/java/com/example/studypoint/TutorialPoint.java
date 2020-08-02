package com.example.studypoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class TutorialPoint extends AppCompatActivity {
    WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_point);
        mywebview=(WebView)findViewById(R.id.tutorial);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebview.loadUrl("https://www.tutorialspoint.com/index.htm");
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
