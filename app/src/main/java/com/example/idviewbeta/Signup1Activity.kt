package com.example.idviewbeta

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.regex.Pattern

class Signup1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup1)

        // email 입력 내용 확인
        val userEmail = findViewById<TextView>(R.id.editTextEmailAddress)
        val emailCheck = findViewById<TextView>(R.id.checkEmail)
        val emailPattern : Pattern = android.util.Patterns.EMAIL_ADDRESS
        userEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(emailPattern.matcher(p0.toString()).matches()){
                    emailCheck.setText("*사용 가능한 이메일입니다.")
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })


        val userPasswd = findViewById<TextView>(R.id.editTextTextPassword)
        val reUserPasswd = findViewById<TextView>(R.id.editTextTextPassword2)

        val passwdCheck = findViewById<TextView>(R.id.matchPasswd)

        userPasswd.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val pwRegex = """^[0-9a-zA-Z!@_#$%^+\-=]*$"""
            val pwPattern = Pattern.compile(pwRegex)
            if (source.isNullOrBlank() || pwPattern.matcher(source).matches()) {
                return@InputFilter source
            }
            makeToast("입력할 수 없는 문자입니다: $source")
            ""
        })

        reUserPasswd.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val pwRegex = """^[0-9a-zA-Z!@_#$%^+\-=]*$"""
            val pwPattern = Pattern.compile(pwRegex)
            if (source.isNullOrBlank() || pwPattern.matcher(source).matches()) {
                return@InputFilter source
            }
            makeToast("입력할 수 없는 문자입니다: $source")
            ""
        })

        reUserPasswd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(reUserPasswd.text.toString() == userPasswd.text.toString()){
                    passwdCheck.setText("*비밀번호가 일치합니다.")
                    // 이후 비밀번호와 이메일은 서버로 보내야 할 듯?
                    // 앱에 저장을.. 어떻게 해야할 지 모르겠어서 일단 보류할게요.
                }

            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        val btnNextSignup1 = findViewById<Button>(R.id.btnNextSignup1)
        btnNextSignup1.setOnClickListener {
            IntroActivity.prefEditor.putString("UserEmail", userEmail.text.toString())
            IntroActivity.prefEditor.apply()
            Log.v("pref_result", IntroActivity.pref.getString("UserEmail", "Value is empty").toString())
            val email = userEmail.text.toString()
            val password = userPasswd.text.toString()
            val url = "signup"

            val connection = ConnectFlask(url)
            connection.getServer(email, password)

            val signup1Intent = Intent(this@Signup1Activity, Signup2Activity::class.java)
            startActivity(signup1Intent)
        }
    }

    private fun makeToast(text: String) {
        val myToast : Toast = Toast.makeText(this.applicationContext, text, Toast.LENGTH_SHORT)
        myToast.show()
    }
}