package com.example.idviewbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idviewbeta.databinding.ActivitySignup3Binding

class Signup3Activity : AppCompatActivity() {
    private lateinit var signup3Binding : ActivitySignup3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signup3Binding = ActivitySignup3Binding.inflate(layoutInflater)
        val view = signup3Binding.root
        setContentView(view)

        signup3Binding.btnSignup3Next.setOnClickListener {
            var nickname = signup3Binding.editTextNickName.text.toString()
            var sign3Intent = Intent(this@Signup3Activity, HomeActivity::class.java)
            startActivity(sign3Intent)
        }
    }
}