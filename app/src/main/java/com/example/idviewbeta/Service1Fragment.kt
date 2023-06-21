package com.example.idviewbeta

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.idviewbeta.databinding.FragmentService1Binding
import kotlinx.android.synthetic.main.fragment_service1.*
import kotlinx.android.synthetic.main.fragment_service1.view.*

class Service1Fragment : Fragment() {
    private lateinit var service1Binding:FragmentService1Binding
    private val pref : SharedPreferences = IntroActivity.pref
    var isConnected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        service1Binding = FragmentService1Binding.inflate(inflater, container, false)
        return service1Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nickname : String = pref.getString("NickName", "별명이 지정되지 않았습니다.").toString()
        val hello = "안녕하세요. ${nickname}님"

        val helloNickname = service1Nickname.service1Nickname
        helloNickname.setText(hello)

        val btnGoPolicyCi = service1Binding.btnGoPolicyCi
        btnGoPolicyCi.setOnClickListener{
            val doCiIntent = Intent(requireActivity(), ConnectCiActivity::class.java)
            startActivity(doCiIntent)
        }

        val not_connect_yet = service1Binding.notConnectYet
        val ciNumber = service1Binding.ciNumber
        val gae = service1Binding.gae

        if (isConnected) {
            btnGoPolicyCi.visibility = View.GONE
            not_connect_yet.visibility = View.GONE
            ciNumber.visibility = View.VISIBLE
            gae.visibility = View.VISIBLE
        }

    }

}