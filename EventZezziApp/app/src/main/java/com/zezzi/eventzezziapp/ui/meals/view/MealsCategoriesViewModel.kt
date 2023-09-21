package com.zezzi.eventzezziapp.ui.meals.view

import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.ui.meals.repository.MealsRepository

class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}