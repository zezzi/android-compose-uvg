package com.zezzi.eventzezziapp.ui.categories.repository

import com.zezzi.eventzezziapp.networking.MealsWebService
import com.zezzi.eventzezziapp.networking.response.Categories
import com.zezzi.eventzezziapp.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMealsCategories(): List<Categories> {
        return webService.getMealsCategories().categories
    }
}