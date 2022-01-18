package com.example.fruitsappbabcom.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FruitsList(
    val fruits : List<Fruit>
)
@JsonClass(generateAdapter = true)
data class Fruit(
    val name: String,
    val image: String,
    val description: String,
    val price: Int
)
