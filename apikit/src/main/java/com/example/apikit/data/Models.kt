package com.example.apikit.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(
    val email: String,
    val password: String
)

@Serializable
data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)

@Serializable
data class AuthResponse(
    val token: String,
    val user: UserDto
)

@Serializable
data class UpdateProfileRequest(
    val username: String? = null,
    val email: String? = null,
    val avatarUrl: String? = null
)

@Serializable
data class UserDto(
    val id: String,
    val username: String,
    val email: String,
    val avatarUrl: String? = null
)

@Serializable
data class LogoutResponse(
    val success: Boolean,
    val message: String
)

@Serializable
data class CreateGameRequest(
    val title: String,
    val description: String? = null,
    val maxPlayers: Int
)

@Serializable
data class GameDto(
    val id: String,
    val title: String,
    val description: String? = null,
    val maxPlayers: Int,
    val currentPlayers: Int,
    val status: String
)

@Serializable
data class CreateGameResponse(
    val success: Boolean,
    val game: GameDto
)

@Serializable
data class GamesResponse(
    val games: List<GameDto>
)

@Serializable
data class JoinGameRequest(
    @SerialName("game_id")
    val gameId: String
)

@Serializable
data class JoinGameResponse(
    val success: Boolean,
    val message: String
)

@Serializable
data class PlayerStatsDto(
    val userId: String,
    val gamesPlayed: Int,
    val wins: Int,
    val losses: Int,
    val rating: Int
)

@Serializable
data class SaveGameResultRequest(
    val gameId: String,
    val score: Int,
    val isWin: Boolean
)

@Serializable
data class SaveGameResultResponse(
    val success: Boolean,
    val message: String
)

@Serializable
data class MessageResponse(
    val success: Boolean,
    val message: String
)