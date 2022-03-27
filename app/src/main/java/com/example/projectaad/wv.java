package com.example.projectaad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class wv extends AppCompatActivity {

    WebView webv;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wv);

        Intent receiver=getIntent();
        url=receiver.getStringExtra("URL");

        webv=findViewById(R.id.webv);
        webv.loadUrl(url);
        webv.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings= webv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);


        webv.setWebViewClient(new WebViewClient());

    }

}