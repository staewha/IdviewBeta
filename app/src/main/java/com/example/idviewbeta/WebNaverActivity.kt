package com.example.idviewbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class WebNaverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_naver)

        val naverWebView = findViewById<WebView>(R.id.web_view_naver)
        naverWebView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            setSupportMultipleWindows(true)
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }
        naverWebView.apply {
            webViewClient = WebViewClient()
            loadUrl("https://nid.naver.com/internalToken/view/tokenList/pc/ko")
        }
    }
}