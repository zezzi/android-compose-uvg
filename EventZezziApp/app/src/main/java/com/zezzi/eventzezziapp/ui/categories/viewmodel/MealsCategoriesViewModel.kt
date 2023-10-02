package com.zezzi.eventzezziapp.ui.categories.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.networking.response.Categories
import com.zezzi.eventzezziapp.ui.categories.repository.MealsCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel (private val repository: MealsCategoryRepository = MealsCategoryRepository()): ViewModel() {

    val mealsState: MutableState<List<Categories>> =  mutableStateOf(emptyList<Categories>())

    init {
        Log.d("TAG_COROUTINES", "about to launch a coroutine")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINES", "launching a coroutine")
            val meals = getMealsCategories()
            Log.d("TAG_COROUTINES", "we have received sync data")
            mealsState.value = meals
        }
        Log.d("TAG_COROUTINES", "other work")
    }

    private suspend fun getMealsCategories(): List<Categories> {
        return repository.getMealsCategories()
    }
}