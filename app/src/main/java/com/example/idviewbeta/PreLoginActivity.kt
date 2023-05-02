package com.example.idviewbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PreLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_login)

        val loginTextView = findViewById<TextView>(R.id.connect_login)
        val signupButton = findViewById<Button>(R.id.btnSignup)

        loginTextView.setOnClickListener {
            val connectLoginIntent = Intent(this@PreLoginActivity, LoginActivity::class.java)
            startActivity(connectLoginIntent)
        }

        signupButton.setOnClickListener {
            val connectSignupIntent = Intent(this@PreLoginActivity, Signup1Activity::class.java)
            startActivity(connectSignupIntent)
        }
    }
}