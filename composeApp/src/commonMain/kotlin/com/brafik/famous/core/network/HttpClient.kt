package com.brafik.famous.core.network

interface HttpClient {
    fun makeRequest(isError: Boolean): String
}

class DemoHttpClient : HttpClient {
    override fun makeRequest(isError: Boolean): String {
        println("Fake request")
        return if (isError) "Error" else "Success"
    }
}