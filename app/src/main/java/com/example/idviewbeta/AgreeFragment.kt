package com.example.idviewbeta

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class AgreeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val agreeFragmentView = inflater.inflate(R.layout.fragment_agree, container, false)
        val btnDoCi = agreeFragmentView.findViewById<Button>(R.id.btnDoCI)
        btnDoCi.setOnClickListener {
            val doCiIntent = Intent(requireActivity(), ConnectCiActivity::class.java)
            startActivity(doCiIntent)
        }
        return agreeFragmentView
    }
}