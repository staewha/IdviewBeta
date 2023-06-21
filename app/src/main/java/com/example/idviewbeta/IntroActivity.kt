package com.example.idviewbeta

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class IntroActivity : AppCompatActivity() {
    companion object {
        lateinit var pref: SharedPreferences
        lateinit var prefEditor: SharedPreferences.Editor
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        prefEditor = pref.edit()

        Handler().postDelayed(Runnable {
            val introIntent = Intent(this@IntroActivity, ConsentActivity::class.java)
            startActivity(introIntent)
        }, 4000)
    }
}