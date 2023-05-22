package com.example.idviewbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class WebGoogleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_google)

        val googleWebView = findViewById<WebView>(R.id.web_view_google)
        googleWebView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            setSupportMultipleWindows(true)
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }
        googleWebView.apply {
            webViewClient = WebViewClient()
            loadUrl("https://myaccount.google.com/permissions?continue=https%3A%2F%2Fmyaccount.google.com%2Fdata-and-privacy")
        }
    }

}