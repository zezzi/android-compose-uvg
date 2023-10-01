package com.zezzi.eventzezziapp.ui.categories.viewmodel

import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.networking.response.Categories
import com.zezzi.eventzezziapp.ui.categories.repository.MealsRepository

class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMealsCategories(): List<Categories> {
        return repository.getMealsCategories().categories
    }
}