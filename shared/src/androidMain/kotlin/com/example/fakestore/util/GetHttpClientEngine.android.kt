package com.example.fakestore.util

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android

actual fun getHttpClientEngine(): HttpClientEngine = Android.create()