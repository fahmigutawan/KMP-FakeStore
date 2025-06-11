package com.example.fakestore.data

import com.example.fakestore.model.response.SingleProductResponse
import com.example.fakestore.util.getHttpClientEngine
import com.fab1an.kotlinjsonstream.JsonReader
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.client.HttpClient
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class Source {
    val client = HttpClient(getHttpClientEngine())

    @NativeCoroutines
    suspend fun getProducts(): List<SingleProductResponse> {
        val json = client.get("https://fakestoreapi.com/products").bodyAsText()
        val list = ArrayList<SingleProductResponse>()

        val jsonReader = JsonReader(json)
        jsonReader.beginArray()

        while(jsonReader.hasNext()){
            jsonReader.beginObject()
            var data = SingleProductResponse(
                id = 0,
                title = "",
                price = .0,
                description = "",
                category = "",
                image = ""
            )

            while(jsonReader.hasNext()){
                when(jsonReader.nextName()){
                    "id" -> data = data.copy(id = jsonReader.nextInt())
                    "title" -> data = data.copy(title = jsonReader.nextString())
                    "price" -> data = data.copy(price = jsonReader.nextDouble())
                    "description" -> data = data.copy(description = jsonReader.nextString())
                    "category" -> data = data.copy(category = jsonReader.nextString())
                    "image" -> data = data.copy(image = jsonReader.nextString())
                    else -> jsonReader.skipValue()
                }
            }
            jsonReader.endObject()
            list.add(data)
        }

        jsonReader.endArray()

        return list
    }
}