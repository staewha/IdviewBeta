package com.example.idviewbeta

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class Service2Adapter(fragment:Fragment, var googleFlag : Boolean, var kakaoFlag : Boolean,
                        var naverFlag : Boolean) :FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
//            0 -> if(googleFlag or kakaoFlag or naverFlag){ AllFragment()
//            }else{ AgreeFragment() }
            0 -> AgreeFragment()

//            1 -> if(googleFlag){ GoogleFragment()
//            }else{ AgreeFragment() }
            1 -> GoogleFragment()

            2 -> AgreeFragment()

            3 -> AgreeFragment()

            else -> throw IndexOutOfBoundsException()
        }

    }
}