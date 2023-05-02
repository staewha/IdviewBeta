package com.example.idviewbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConsentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consent)

        val btnAgreePolicy = findViewById<Button>(R.id.btnPolicyAgree)

        btnAgreePolicy.setOnClickListener {
            // 권한 요청 코드 작성할 것

            val consentIntent = Intent(this@ConsentActivity, PreLoginActivity::class.java)
            startActivity(consentIntent)
        }
    }
}