package com.zezzi.eventzezziapp.networking

import com.zezzi.eventzezziapp.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.networking.response.MealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    suspend fun getMealsCategories(): MealsCategoriesResponse

    @GET("filter.php")
    suspend fun filterByCategory(
        @Query("c") category: String
    ): MealsResponse
}