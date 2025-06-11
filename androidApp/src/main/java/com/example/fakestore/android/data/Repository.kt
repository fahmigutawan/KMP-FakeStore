package com.example.fakestore.android.data

import com.example.fakestore.data.Source
import com.example.fakestore.model.response.SingleBannerResponse
import com.example.fakestore.model.response.SingleProductResponse
import com.example.fakestore.util.getResponse
import javax.inject.Inject

class Repository @Inject constructor(
    private val source: Source,
) {
    fun getProducts() = getResponse {
        source.getProducts()
    }

    fun getBanners() = getResponse {
        source.getBanners()
    }

    fun getProductById(id: Int) = getResponse {
        source.getProductById(id)
    }
}