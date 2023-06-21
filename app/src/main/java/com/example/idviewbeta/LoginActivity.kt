package com.example.idviewbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.Toast
import com.example.idviewbeta.databinding.ActivityLoginBinding
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.editTextLoginEmailAddress.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val pwRegex = """^[0-9a-zA-Z@_.]*$"""
            val pwPattern = Pattern.compile(pwRegex)
            if (source.isNullOrBlank() || pwPattern.matcher(source).matches()) {
                return@InputFilter source
            }
            makeToast("입력할 수 없는 문자입니다: $source")
            ""
        })

        loginBinding.editTextLoginPasswd.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val pwRegex = """^[0-9a-zA-Z!@_#$%^+\-=]*$"""
            val pwPattern = Pattern.compile(pwRegex)
            if (source.isNullOrBlank() || pwPattern.matcher(source).matches()) {
                return@InputFilter source
            }
            makeToast("입력할 수 없는 문자입니다: $source")
            ""
        })

        loginBinding.btnLogin.setOnClickListener {
            val loginEmailAddr = loginBinding.editTextLoginEmailAddress.text.toString()
            val loginPasswd = loginBinding.editTextLoginPasswd.text.toString()

            val url = "login"

            val connection = ConnectFlask(url)
            connection.getServer(loginEmailAddr, loginPasswd)
            val loginIntent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(loginIntent)
        }

    }

    private fun makeToast(text: String) {
        val myToast : Toast = Toast.makeText(this.applicationContext, text, Toast.LENGTH_SHORT)
        myToast.show()
    }
}