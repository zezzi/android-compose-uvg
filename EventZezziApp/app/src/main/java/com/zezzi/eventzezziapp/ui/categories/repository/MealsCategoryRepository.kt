package com.zezzi.eventzezziapp.ui.categories.repository

import com.zezzi.eventzezziapp.networking.MealsWebService
import com.zezzi.eventzezziapp.networking.response.Categories

class MealsCategoryRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMealsCategories(): List<Categories> {
        return webService.getMealsCategories().categories
    }
}