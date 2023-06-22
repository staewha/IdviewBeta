package com.example.idviewbeta

interface ServerCallback {
    fun onSuccess(response: String?)
    fun onFailure()
}