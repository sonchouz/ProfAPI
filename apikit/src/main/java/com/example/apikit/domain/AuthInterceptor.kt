package com.example.apikit.domain

import com.example.apikit.data.TokenProvider
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor ( private val tokenProvider: TokenProvider
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val token = tokenProvider.getToken()

        val requestBuilder = original.newBuilder()

        if (!token.isNullOrBlank()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(requestBuilder.build())
    }
}