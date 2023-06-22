package com.example.idviewbeta

import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class ConnectFlask(private val url: String) {
    // API 엔드포인트 설정
    private val testUrl: String = "http://localhost:5000/api/$url"
    fun getServer(loginEmailAddr:String, loginPasswd:String, callback: ServerCallback) {
        try {
            // OkHttpClient 생성
            val client = OkHttpClient()

            // JSON 데이터 생성
            val json = JSONObject()
            json.put("email", loginEmailAddr)
            json.put("password", loginPasswd)
            // json.put("nickname", loginNickname) // nickname일단 제외..

            // 요청 헤더에 'Content-Type: application/json' 설정
            val mediaType = "application/json".toMediaType()
            val requestBody = json.toString().toRequestBody(mediaType)
            val request = Request.Builder()
                .url(testUrl)
                .post(requestBody)
                .header("Content-Type", "application/json")
                .build()

            val response =  client.newCall(request).execute()
            if (response.isSuccessful) {
                val responseData = response.body?.string() // 응답 본문의 데이터를 가져옴
                Log.v("ConnectFlask", "서버 응답 성공: ${responseData}")
                callback.onSuccess(responseData)
            } else {
                // 응답이 실패한 경우 처리
                Log.e("ConnectFlask", "서버 응답이 실패했습니다. 상태 코드: ${response.code}")
                callback.onFailure()
            }
            Log.v("ConnectFlask", (response).toString())

        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }
}