package com.sanmiaderibigbe.firstchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AboutALCActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private  WebView webView;

    public static Intent newAboutALCActivity(Context context) {
        return  new Intent(context, AboutALCActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        getSupportActionBar().setTitle("About ALC");


        progressBar = findViewById(R.id.web_view_progressbar);
        webView = findViewById(R.id.web_view);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        initLoadingScreen();
        initWebViewListener(webView);


    }

    private void initWebViewListener(WebView webView) {
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Toast.makeText(AboutALCActivity.this, description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                terminateLoadingScreen();
                super.onPageFinished(view, url);
            }
        });

        webView.loadUrl("https://andela.com/alc/");
    }

    private void initLoadingScreen(){
        progressBar.setVisibility(View.VISIBLE);
        webView.setVisibility(View.INVISIBLE);
    }

    private void terminateLoadingScreen(){
        progressBar.setVisibility(View.INVISIBLE);
        webView.setVisibility(View.VISIBLE);
    }
}
