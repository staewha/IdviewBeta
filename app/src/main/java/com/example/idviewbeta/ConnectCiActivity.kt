package com.example.idviewbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConnectCiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect_ci)

        val btnConnectGoogleCi = findViewById<Button>(R.id.btnConnectGoogleCi)
        btnConnectGoogleCi.setOnClickListener {
            val googleCiIntent = Intent(this@ConnectCiActivity, WebGoogleActivity::class.java)
            startActivity(googleCiIntent)

        }
        val btnConnectKakaoCi = findViewById<Button>(R.id.btnConnectKakaoCi)
        btnConnectKakaoCi.setOnClickListener {
            val kakaoCiIntent = Intent(this@ConnectCiActivity, WebKakaoActivity::class.java)
            startActivity(kakaoCiIntent)
        }
        val btnConnectNaverCi = findViewById<Button>(R.id.btnConnectNaverCi)
        btnConnectNaverCi.setOnClickListener {
            val naverCiIntent = Intent(this@ConnectCiActivity, WebNaverActivity::class.java)
            startActivity(naverCiIntent)
        }
        val btnReturnService = findViewById<Button>(R.id.btnReturnService)
        btnReturnService.setOnClickListener {
            val returnIntent = Intent(this@ConnectCiActivity, HomeActivity::class.java)
            startActivity(returnIntent)
        }
    }
}