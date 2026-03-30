package com.example.apikit.data

class InMemoryTokenProvider: TokenProvider {
    private var token: String? = null

    override fun getToken(): String? = token

    override fun setToken(token: String?) {
        this.token = token
    }
}