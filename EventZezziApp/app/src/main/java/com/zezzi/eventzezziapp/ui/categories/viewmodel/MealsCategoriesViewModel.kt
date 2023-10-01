package com.zezzi.eventzezziapp.ui.categories.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.remember
import com.zezzi.eventzezziapp.networking.response.Categories
import com.zezzi.eventzezziapp.ui.categories.repository.MealsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {

    val mealsState: MutableState<List<Categories>> =  mutableStateOf(emptyList<Categories>())

    private val mealsJob = Job()
    init {
        val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        scope.launch(Dispatchers.IO) {
            val meals = getMealsCategories()
            mealsState.value = meals
        }
    }

    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }

    private suspend fun getMealsCategories(): List<Categories> {
        return repository.getMealsCategories().categories
    }
}