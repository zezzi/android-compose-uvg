package com.zezzi.eventzezziapp.networking

import com.zezzi.eventzezziapp.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface MealsApi {
    @GET("categories.php")
    fun getMeals(): Call<MealsCategoriesResponse>
}