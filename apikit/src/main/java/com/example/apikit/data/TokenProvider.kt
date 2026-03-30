package com.example.apikit.data

interface TokenProvider {
    fun getToken(): String?
    fun setToken(token: String?)
}