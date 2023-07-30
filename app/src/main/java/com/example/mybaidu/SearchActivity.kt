package com.example.mybaidu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import java.lang.Exception

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val webview = findViewById<WebView>(R.id.webview_search)
        webview.loadUrl("https://m.baidu.com/")
//        webview.loadDataWithBaseURL("url","","text/html","utf-8",null)
        webview.settings.javaScriptEnabled = true
        webview.settings.useWideViewPort = true

        webview.webViewClient = object : WebViewClient() {
            // 在 WebView 内加载网页
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try{
                    if(url.startsWith("baidu://")){
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true
                    }
                }catch ( e:Exception) {
                    return true
                }
                view.loadUrl(url)
                return true
            }
        }
        webview.onResume()
    }
}