package com.example.apikit.domain

import com.example.apikit.data.AuthRequest
import com.example.apikit.data.AuthResponse
import com.example.apikit.data.CreateGameRequest
import com.example.apikit.data.CreateGameResponse
import com.example.apikit.data.GameDto
import com.example.apikit.data.GamesResponse
import com.example.apikit.data.JoinGameRequest
import com.example.apikit.data.JoinGameResponse
import com.example.apikit.data.LogoutResponse
import com.example.apikit.data.PlayerStatsDto
import com.example.apikit.data.RegisterRequest
import com.example.apikit.data.SaveGameResultRequest
import com.example.apikit.data.SaveGameResultResponse
import com.example.apikit.data.UpdateProfileRequest
import com.example.apikit.data.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface GameApiService {

    @POST("auth/login")
    suspend fun login(
        @Body request: AuthRequest
    ): AuthResponse

    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): AuthResponse

    @PUT("profile")
    suspend fun updateProfile(
        @Body request: UpdateProfileRequest
    ): UserDto

    @GET("profile")
    suspend fun getProfile(): UserDto

    @POST("auth/logout")
    suspend fun logout(): LogoutResponse

    @POST("games")
    suspend fun createGame(
        @Body request: CreateGameRequest
    ): CreateGameResponse

    @GET("games")
    suspend fun getGames(): GamesResponse

    @GET("games/{id}")
    suspend fun getGameInfo(
        @Path("id") gameId: String
    ): GameDto

    @POST("games/join")
    suspend fun joinGame(
        @Body request: JoinGameRequest
    ): JoinGameResponse

    @GET("stats")
    suspend fun getPlayerStats(): PlayerStatsDto

    @POST("games/result")
    suspend fun saveGameResult(
        @Body request: SaveGameResultRequest
    ): SaveGameResultResponse
}