package com.example.idviewbeta

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.idviewbeta.databinding.FragmentService2Binding
import com.google.android.material.tabs.TabLayoutMediator


class Service2Fragment : Fragment() {
    private lateinit var service2Binding:FragmentService2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        service2Binding = FragmentService2Binding.inflate(inflater, container, false)
        return service2Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val service2Tab = service2Binding.service2Tab
        val service2ViewPager = service2Binding.service2ViewPager

        service2ViewPager.adapter = Service2Adapter(this, false, false, false)

        TabLayoutMediator(service2Tab, service2ViewPager) { tab, position ->
            when(position) {
                0 -> tab.setText(R.string.all)
                1 -> tab.setText(R.string.google)
                2 -> tab.setText(R.string.kakao)
                3 -> tab.setText(R.string.naver)
            }
        }.attach()
    }

}