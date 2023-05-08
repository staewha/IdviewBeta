package com.example.idviewbeta

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class Service2Adapter(fragment:Fragment, googleFlag : Boolean, kakaoFlag : Boolean,
                        naverFlag : Boolean) :FragmentStateAdapter(fragment) {
    var googleFlag = googleFlag
    var kakaoFlag = kakaoFlag
    var naverFlag = naverFlag
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> if(googleFlag or kakaoFlag or naverFlag){ AllFragment()
            }else{ AgreeFragment() }

            1 -> if(googleFlag){ GoogleFragment()
            }else{ AgreeFragment() }

            2 -> if(kakaoFlag){ KakaoFragment()
            }else{ AgreeFragment() }

            3 -> if(naverFlag){ NaverFragment()
            }else{ AgreeFragment() }

            else -> throw IndexOutOfBoundsException()
        }

    }
}