package com.example.apikit.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException


suspend inline fun <T> safeApiCall(
    crossinline apiCall: suspend () -> T
): ApiResult<T> {
    return withContext(Dispatchers.IO) {
        try {
            ApiResult.Success(apiCall())
        } catch (e: SocketTimeoutException) {
            ApiResult.Error(
                message = "Превышено время ожидания ответа от сервера",
                cause = e
            )
        } catch (e: IOException) {
            ApiResult.Error(
                message = "Нет соединения с Интернетом или сервер недоступен",
                cause = e
            )
        } catch (e: HttpException) {
            val code = e.code()
            ApiResult.Error(
                message = "Ошибка сервера: HTTP $code",
                code = code,
                cause = e
            )
        } catch (e: Exception) {
            ApiResult.Error(
                message = "Неизвестная ошибка: ${e.localizedMessage ?: "без описания"}",
                cause = e
            )
        }
    }
}