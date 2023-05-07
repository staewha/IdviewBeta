package com.example.idviewbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.idviewbeta.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    lateinit var homeBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        // 뷰페이저에 어댑터 연결
        var viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.addFragment(Service1Fragment())
        viewPagerAdapter.addFragment(Service2Fragment())
        viewPagerAdapter.addFragment(Service3Fragment())
        viewPagerAdapter.addFragment(Service4Fragment())

        homeBinding.homeViewPager.apply {
            adapter = viewPagerAdapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        /* 탭과 뷰페이저를 연결, 여기서 새로운 탭을 다시 만드므로 레이아웃에서 꾸미지말고
        여기서 꾸며야함
         */
        TabLayoutMediator(homeBinding.homeTabLayout, homeBinding.homeViewPager) {tab, position ->
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