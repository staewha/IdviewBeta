package com.example.idviewbeta

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.idviewbeta.databinding.FragmentService4Binding

class Service4Fragment : Fragment() {
    private lateinit var service4Binding:FragmentService4Binding
    private val pref : SharedPreferences = IntroActivity.pref

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        service4Binding = FragmentService4Binding.inflate(inflater, container, false)
        return service4Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nickname = pref.getString("NickName", "별명이 지정되지 않았습니다.").toString()
        val email = pref.getString("UserEmail", "email이 지정되지 않았습니다.").toString()

        val profNickname = service4Binding.profNickName
        val profEmail = service4Binding.profEmail

        profNickname.setText(nickname)
        profEmail.setText(email)
    }

}