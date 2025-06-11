package com.example.fakestore.util

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

@NativeCoroutines
inline fun <reified T> getResponse(
    crossinline block: suspend () -> T
) = flow {
    emit(Resource.Loading())
    delay(500)

    try {
        val res = block()
        emit(Resource.Success(res))
    } catch (e: HttpRequestTimeoutException) {
        e.printStackTrace()
        emit(Resource.Error("Timeout. Pastikan internet anda menyala atau coba lagi nanti"))
    } catch (e: Exception) {
        e.printStackTrace()
        emit(Resource.Error("Terjadi error saat menghubungkan ke server"))
    }
}