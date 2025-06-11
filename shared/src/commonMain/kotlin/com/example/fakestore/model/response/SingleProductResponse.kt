package com.example.fakestore.model.response

data class SingleProductResponse(
    val id: Int,
    val title:String,
    val price: Double,
    val description:String,
    val category:String,
    val image:String
)
