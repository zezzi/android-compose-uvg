package com.zezzi.eventzezziapp.ui.meals.repository

import com.zezzi.eventzezziapp.networking.MealsWebService
import com.zezzi.eventzezziapp.networking.response.Categories
import com.zezzi.eventzezziapp.networking.response.Meal

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun filterByCategory(category: String): List<Meal> {
        return webService.filterMealsByCategory(category).meals
    }
}