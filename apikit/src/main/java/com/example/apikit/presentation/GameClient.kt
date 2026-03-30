package com.example.apikit.presentation

import com.example.apikit.data.GameApiFactory
import com.example.apikit.data.GameRepository
import com.example.apikit.data.InMemoryTokenProvider
import com.example.apikit.data.TokenProvider

class GameClient private constructor(
    val repository: GameRepository
) {
    companion object {
        fun create(
            baseUrl: String,
            tokenProvider: TokenProvider = InMemoryTokenProvider()
        ): GameClient {
            val api = GameApiFactory.create(
                baseUrl = baseUrl,
                tokenProvider = tokenProvider
            )

            val repository = GameRepository(
                api = api,
                tokenProvider = tokenProvider
            )

            return GameClient(repository)
        }
    }
}