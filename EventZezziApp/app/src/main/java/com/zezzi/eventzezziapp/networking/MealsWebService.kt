package com.zezzi.eventzezziapp.networking

import com.zezzi.eventzezziapp.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.networking.response.MealsResponse
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {

    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMealsCategories(): MealsCategoriesResponse {
        return api.getMealsCategories()
    }

    suspend fun filterMealsByCategory(category: String): MealsResponse {
        return api.filterByCategory(category)
    }
}