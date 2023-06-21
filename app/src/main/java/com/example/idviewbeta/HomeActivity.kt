package com.example.idviewbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.idviewbeta.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    lateinit var homeBinding : ActivityHomeBinding
    lateinit var viewPagerAdapter : ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        // 뷰페이저에 어댑터 연결
        viewPagerAdapter = ViewPagerAdapter(this)
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
                0 -> tab.text = "Home"
                1 -> tab.text = "List"
                2 -> tab.text = "Map"
                3 -> tab.text = "MyPage"
            }
        }.attach()


    }

    fun retreiveFragment(){
        val fragment = viewPagerAdapter.fragments[0]
        if (fragment is Service1Fragment){
            Log.v("Service1Fragment","It is Service1Fragment")
            fragment.updateServiceInfo()
        } else{
            Log.v("Service1Fragment","It is not Service1Fragment")
        }
    }

}

class TestData(
    private var serviceName : String? = null,
    private var serviceDomain : String? = null,
    private var policyDomain : String? = null,
    private var privacyList : List<String>? = null
) {
    fun getServiceName() : String? {
        return serviceName
    }
    fun setServiceName(serviceName : String) {
        this.serviceName = serviceName
    }
    fun getServiceDomain() : String? {
        return serviceDomain
    }
    fun setServiceDomain(serviceDomain : String) {
        this.serviceDomain = serviceDomain
    }
    fun getPolicyDomain() : String? {
        return policyDomain
    }
    fun setPolicyDomain(policyDomain : String) {
        this.policyDomain = policyDomain
    }
    fun getPrivacyList() : List<String>? {
        return privacyList
    }
    fun setPrivacyList(privacyList: List<String>?) {
        this.privacyList = privacyList
    }
}