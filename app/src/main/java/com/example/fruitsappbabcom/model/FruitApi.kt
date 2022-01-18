package com.example.fruitsappbabcom.model

import com.example.fruitsappbabcom.data.Fruit
import com.example.fruitsappbabcom.data.FruitsList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface FruitApi{
    @GET("fruitsBT/getFruits")
    suspend fun getFruits() : FruitsList
}

object FruitApiService{
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://dev-api.com/")
        .build()
    private val fruitService = retrofit.create(FruitApi::class.java)
    suspend fun getFruitsService():FruitsList{
        return withContext(Dispatchers.IO){
            fruitService.getFruits()
        }
    }
}