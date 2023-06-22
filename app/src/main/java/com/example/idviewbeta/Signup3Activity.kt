package com.example.idviewbeta

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.idviewbeta.databinding.ActivitySignup3Binding

class Signup3Activity : AppCompatActivity() {
    private lateinit var signup3Binding : ActivitySignup3Binding
    private val pref : SharedPreferences = IntroActivity.pref
    private val prefEditor: SharedPreferences.Editor = pref.edit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signup3Binding = ActivitySignup3Binding.inflate(layoutInflater)
        val view = signup3Binding.root
        setContentView(view)

        // 전달된 email과 password 정보 받기
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        signup3Binding.btnSignup3Next.setOnClickListener {
            val nickname = signup3Binding.editTextNickName.text.toString()
            // 아이디, 비밀번호, 닉네임 정보를 SharedPreferences에 저장
            prefEditor.putString("UserEmail", email)
            prefEditor.putString("UserPassword", password)
            prefEditor.putString("NickName", nickname)
            prefEditor.apply()

            Log.v("pref_result", pref.getString("NickName", "Value is empty").toString())
            val sign3Intent = Intent(this@Signup3Activity, HomeActivity::class.java)
            startActivity(sign3Intent)
            // 닉네임을 받자니 아이디와 비밀번호를 다른 곳에서 받고 있어서
        }
    }
}