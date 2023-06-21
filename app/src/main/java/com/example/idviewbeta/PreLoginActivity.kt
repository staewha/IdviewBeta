package com.example.idviewbeta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.idviewbeta.db.*

class PreLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_login)

        val loginTextView = findViewById<TextView>(R.id.connect_login)
        val signupButton = findViewById<Button>(R.id.btnSignup)

        loginTextView.setOnClickListener {
            val connectLoginIntent = Intent(this@PreLoginActivity, LoginActivity::class.java)
            startActivity(connectLoginIntent)
        }

        signupButton.setOnClickListener {
            val connectSignupIntent = Intent(this@PreLoginActivity, Signup1Activity::class.java)
            startActivity(connectSignupIntent)
        }
        // 이것두... 나중에 DB 고치면서 같이 고쳐서 데이터 넣기.. 화산의 제자는 해낼 수 있다.. 화아팅...
//        insertService("Dreamhack", "dreamhack.io", "dreamhack.io/services/privacy")
//        insertService("JOBKOREA", "jobkorea.co.kr", "jobkorea.co.kr/service/PolicyPrivacy")
//        insertService("Programmers", "programmers.co.kr", "programmers.co.kr/privacy")
//        insertService("RIDI", "ridibooks.com", "policy.ridi.com/legal/privacy")
//        insertService("교보문고", "product.kyobobook.co.kr", "kyobobook.co.kr/contents/privacy-policy")
//        insertService("인프런", "inflearn.com", "inflearn.com/policy/privacy")
//
//        insertPrivacy("Dreamhack",
//            id = false,
//            passwd = false,
//            name = true,
//            emailAddress = true,
//            phoneNum = true,
//            address = true,
//            birth = true,
//            sex = true,
//            shippingInfo = false,
//            paymentInfo = true
//        )
//        insertPrivacy("JOBKOREA",
//            id = false,
//            passwd = false,
//            name = true,
//            emailAddress = true,
//            phoneNum = true,
//            address = true,
//            birth = false,
//            sex = true,
//            shippingInfo = false,
//            paymentInfo = false)
//        insertPrivacy("Programmers",
//            id = true,
//            passwd = false,
//            name = true,
//            emailAddress = true,
//            phoneNum = true,
//            address = true,
//            birth = true,
//            sex = false,
//            shippingInfo = false,
//            paymentInfo = true)
//        insertPrivacy("RIDI",
//            id = true,
//            passwd = false,
//            name = true,
//            emailAddress = true,
//            phoneNum = true,
//            address = true,
//            birth = true,
//            sex = true,
//            shippingInfo = false,
//            paymentInfo = true)
//        insertPrivacy("교보문고",
//            id = true,
//            passwd = true,
//            name = true,
//            emailAddress = true,
//            phoneNum = true,
//            address = true,
//            birth = true,
//            sex = true,
//            shippingInfo = true,
//            paymentInfo = true)
//        insertPrivacy("인프런",
//            id = false,
//            passwd = false,
//            name = true,
//            emailAddress = true,
//            phoneNum = true,
//            address = true,
//            birth = true,
//            sex = true,
//            shippingInfo = false,
//            paymentInfo = true
//        )


    }

    fun insertService(serviceName : String, serviceDomain : String, policyDomain : String) {
        val service = Service(serviceName, serviceDomain, policyDomain)
        val serviceDB : ServiceDatabase = ServiceDatabase.getServiceDBInstance(this.applicationContext)
        serviceDB.serviceDao().insertService(service)

        setResult(Activity.RESULT_OK)
        finish()
    }

    fun insertPrivacy(serviceName: String, id : Boolean, passwd : Boolean, name : Boolean, emailAddress : Boolean, phoneNum : Boolean,
    address : Boolean, birth : Boolean, sex : Boolean, shippingInfo : Boolean, paymentInfo : Boolean) {
        val privacy = Privacy(serviceName, id, passwd, name, emailAddress, phoneNum, address, birth,
                                sex, shippingInfo, paymentInfo)
        val privacyDB : PrivacyDatabase = PrivacyDatabase.getPrivacyDBInstance(this.applicationContext)
        privacyDB.privacyDao().insertPrivacy(privacy)

        setResult(Activity.RESULT_OK)
        finish()
    }


    fun insertConCom(comName : String, secureLevel : Int = 1, country : String = "None") {
        val conCom = ConsignmentCompany(comName, secureLevel, country)

        val conConDB : ConComDataBase = ConComDataBase.getConComDBInstance(this.applicationContext)
        conConDB.conComDao().insertConCo(conCom)

        setResult(Activity.RESULT_OK)
        finish()
    }

}