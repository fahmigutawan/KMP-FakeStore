package com.example.fakestore

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform