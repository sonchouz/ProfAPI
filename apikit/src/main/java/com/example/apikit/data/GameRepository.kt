package com.example.apikit.data

import com.example.apikit.domain.ApiResult
import com.example.apikit.domain.GameApiService
import com.example.apikit.domain.safeApiCall

class GameRepository (
    private val api: GameApiService,
    private val tokenProvider: TokenProvider
    ) {


    suspend fun login(email: String, password: String): ApiResult<AuthResponse> {
            return safeApiCall {
                val response = api.login(AuthRequest(email, password))
                tokenProvider.setToken(response.token)
                response
            }
        }

        suspend fun register(
            username: String,
            email: String,
            password: String
        ): ApiResult<AuthResponse> {
            return safeApiCall {
                val response = api.register(RegisterRequest(username, email, password))
                tokenProvider.setToken(response.token)
                response
            }
        }

        suspend fun updateProfile(
            username: String?,
            email: String?,
            avatarUrl: String?
        ): ApiResult<UserDto> {
            return safeApiCall {
                api.updateProfile(
                    UpdateProfileRequest(
                        username = username,
                        email = email,
                        avatarUrl = avatarUrl
                    )
                )
            }
        }

        suspend fun getProfile(): ApiResult<UserDto> {
            return safeApiCall {
                api.getProfile()
            }
        }

        suspend fun logout(): ApiResult<LogoutResponse> {
            return safeApiCall {
                val response = api.logout()
                tokenProvider.setToken(null)
                response
            }
        }

        suspend fun createGame(
            title: String,
            description: String?,
            maxPlayers: Int
        ): ApiResult<CreateGameResponse> {
            return safeApiCall {
                api.createGame(
                    CreateGameRequest(
                        title = title,
                        description = description,
                        maxPlayers = maxPlayers
                    )
                )
            }
        }

        suspend fun getGames(): ApiResult<GamesResponse> {
            return safeApiCall {
                api.getGames()
            }
        }

        suspend fun getGameInfo(gameId: String): ApiResult<GameDto> {
            return safeApiCall {
                api.getGameInfo(gameId)
            }
        }

        suspend fun joinGame(gameId: String): ApiResult<JoinGameResponse> {
            return safeApiCall {
                api.joinGame(JoinGameRequest(gameId))
            }
        }

        suspend fun getPlayerStats(): ApiResult<PlayerStatsDto> {
            return safeApiCall {
                api.getPlayerStats()
            }
        }

        suspend fun saveGameResult(
            gameId: String,
            score: Int,
            isWin: Boolean
        ): ApiResult<SaveGameResultResponse> {
            return safeApiCall {
                api.saveGameResult(
                    SaveGameResultRequest(
                        gameId = gameId,
                        score = score,
                        isWin = isWin
                    )
                )
            }
        }
}