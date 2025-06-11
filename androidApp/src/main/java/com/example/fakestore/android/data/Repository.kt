package com.example.fakestore.android.data

import com.example.fakestore.data.Source
import com.example.fakestore.model.response.SingleProductResponse
import com.example.fakestore.util.getResponse
import javax.inject.Inject

class Repository @Inject constructor(
    private val source: Source,
) {
    fun getProducts() = getResponse<List<SingleProductResponse>> {
        source.getProducts()
    }
}