package com.example.idviewbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.Toast
import com.example.idviewbeta.databinding.ActivityLoginBinding
import java.util.regex.Pattern
// import okhttp3.OkHttpClient
// import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.editTextLoginEmailAddress.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val pwRegex = """^[0-9a-zA-Z@_]*$"""
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
            // 서버에 로그인 요청

            // JSON 데이터 생성
            val json = JSONObject()
            json.put("email", loginEmailAddr)
            json.put("password", loginPasswd)

            // API 엔드포인트 설정
            val url = "http://localhost:5000/api/signup"

            // 요청 헤더에 'Content-Type: application/json' 설정
            val mediaType = "application/json".toMediaType()
            val requestBody = json.toString().toRequestBody(mediaType)
            val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .header("Content-Type", "application/json")
                .build()

            // OkHttpClient 생성
            val client = OkHttpClient()

            // 요청 보내기
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    // 요청 실패 처리
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    // 응답 처리
                    val responseBody = response.body?.string()
                    runOnUiThread {
                        // UI 업데이트 등의 작업 수행
                        // 응답을 처리하는 코드 작성
                    }
                }
            })

            val loginIntent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(loginIntent)
        }

    }

    private fun makeToast(text: String) {
        val myToast : Toast = Toast.makeText(this.applicationContext, text, Toast.LENGTH_SHORT)
        myToast.show()
    }
}