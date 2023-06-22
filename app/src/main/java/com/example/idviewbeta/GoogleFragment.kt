package com.example.idviewbeta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_google.*

class GoogleFragment : Fragment() {

    private val dataList : ArrayList<TestData> = arrayListOf(
        TestData("Dreamhack", "dreamhack.io", "dreamhack.io/services/privacy",
            listOf("이름", "이메일", "전화번호", "주소", "생년월일", "성별", "결제 정보")),
        TestData("JOBKOREA", "jobkorea.co.kr", "jobkorea.co.kr/service/PolicyPrivacy",
            listOf("이름", "이메일", "전화번호", "주소", "성별")),
        TestData("Programmers", "programmers.co.kr", "programmers.co.kr/privacy",
            listOf("아이디", "이름", "이메일", "전화번호", "주소", "생년월일", "결제 정보")),
        TestData("RIDI", "ridibooks.com", "policy.ridi.com/legal/privacy",
            listOf("아이디", "이름", "이메일", "전화번호", "주소", "생년월일", "성별", "결제 정보")),
        TestData("교보문고", "product.kyobobook.co.kr", "kyobobook.co.kr/contents/privacy-policy",
            listOf("아이디", "비밀번호", "이름", "이메일", "전화번호", "주소", "생년월일", "성별", "배송정보", "결제 정보")),
        TestData("인프런", "inflearn.com", "inflearn.com/policy/privacy",
            listOf("이름", "이메일", "전화번호", "주소", "생년월일", "성별", "결제 정보")),
    )

    private lateinit var listAdapter: ServiceListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val googleFragmentView = inflater.inflate(R.layout.fragment_google, container, false)
        return googleFragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 원래는 homeActivity에서 선언한 후에 전달 받아야하지만... 일단 복잡하니까 넘어갑시다. 마감 3시간 남았다.
        val data: ArrayList<TestData> = dataList
        listAdapter = ServiceListAdapter(data)
        googleServiceList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        googleServiceList.adapter = listAdapter
    }
}

