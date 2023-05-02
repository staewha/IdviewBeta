package com.example.idviewbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idviewbeta.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    lateinit var homeBinding : ActivityHomeBinding
//    private val tabIcons = listOf(
//        R.drawable.tab_icon1,
//        R.drawable.tab_icon2,
//        R.drawable.tab_icon3,
//        R.drawable.tab_icon4
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        // 탭 설정
        homeBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 탭이 선택 되었을 때
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 탭이 선택되지 않은 상태로 변경 되었을 때
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // 이미 선택된 탭이 다시 선택 되었을 때
            }
        })

        // 뷰페이저에 어댑터 연결
        homeBinding.pager.adapter = ViewPagerAdapter(this)

        /* 탭과 뷰페이저를 연결, 여기서 새로운 탭을 다시 만드므로 레이아웃에서 꾸미지말고
        여기서 꾸며야함
         */
        TabLayoutMediator(homeBinding.tabLayout, homeBinding.pager) {tab, position ->
            when(position) {
                // icon들 타입이 안맞아서.. 해결이 안됨.. png파일이나 xml 파일을 왜 int로 인식하는 건지 알 수 X
                0 -> tab.text = "탭1"
                1 -> tab.text = "탭2"
                2 -> tab.text = "탭3"
                3 -> tab.text = "탭4"
            }
        }.attach()

    }
}