package com.example.com.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class webview extends Activity {
    EditText edtUrl;
    Button btnGo , btnBack;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        edtUrl = (EditText) findViewById(R.id.edtUrl);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnGo = (Button)findViewById(R.id.btnGo);
        web = (WebView)findViewById(R.id.web);

        web.setWebViewClient(new CookWebViewClient());

        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String http;
                http = edtUrl.getText().toString();
                if (!http.contains("http://")) {
                    http = "http://" + http;
                }
                web.loadUrl(http);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack();
            }
        });

    }

    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String rul){
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            EditText et =(EditText) view.getRootView().findViewById(R.id.edtUrl);
            et.setText(url);
        }
    }


}
