package com.example.idviewbeta

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragment : FragmentActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Service1Fragment()
            1 -> Service2Fragment()
            2 -> Service3Fragment()
            else -> Service4Fragment()
        }
    }
}