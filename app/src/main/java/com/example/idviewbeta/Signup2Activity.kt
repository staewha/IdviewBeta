package com.example.idviewbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.TextView
import android.widget.Toast
import com.example.idviewbeta.databinding.ActivitySignup2Binding
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import java.util.regex.Pattern

class Signup2Activity : AppCompatActivity() {
    lateinit var signup2Intent: Intent
    private lateinit var signup2Binding : ActivitySignup2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signup2Binding = ActivitySignup2Binding.inflate(layoutInflater)
        val view = signup2Binding.root
        setContentView(view)

        signup2Binding.btnSignup2Back.setOnClickListener{
            signup2Intent = Intent(this@Signup2Activity, Signup1Activity::class.java)
            startActivity(signup2Intent)
        }

        // 시간 text view
//        val timeTextView = findViewById<TextView>(R.id.verifyTimeTextview)

        // 인증 코드 입력 edit text
        signup2Binding.verifyCodeEditText.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val numRegex = """^[0-9]*$"""
            val numPattern = Pattern.compile(numRegex)
            if (source.isNullOrBlank() || numPattern.matcher(source).matches()) {
                return@InputFilter source
            }
            makeToast("숫자만 입력하세요.")
            ""
        })
        // 인증 코드 확인 버튼
        signup2Binding.btnSignup2Confirm.setOnClickListener {
            var verifyNumber = signup2Binding.verifyCodeEditText.text.toString()
            // verfifyNumber를 서버로 보내서 검증 해야함...
            // 구현 보류
        }

        // 이메일 재전송 text 버튼
        signup2Binding.resendTextView.setOnClickListener {
            // 이메일 재전송 요청 보내기
            // 쉽지 않아서... 중간 이후에 보충하겠습니다.
        }

        val s2SlidePanel = signup2Binding.signup2Frame


        // 다음 버튼
        signup2Binding.btnSignup2Next.setOnClickListener {
            val state = s2SlidePanel.panelState
            if(state== SlidingUpPanelLayout.PanelState.COLLAPSED){
                s2SlidePanel.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
            }
        }

        // Signup1Activity에서 전달된 로그인 정보를 받아서 Signup3Activity에 넘겨줌
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        signup2Binding.btnPolicyNext.setOnClickListener {
            signup2Intent = Intent(this@Signup2Activity, Signup3Activity::class.java)
            signup2Intent.putExtra("email", email)
            signup2Intent.putExtra("password", password)

            startActivity(signup2Intent)
        }

    }

    private fun makeToast(text: String) {
        val myToast : Toast = Toast.makeText(this.applicationContext, text, Toast.LENGTH_SHORT)
        myToast.show()
    }
}