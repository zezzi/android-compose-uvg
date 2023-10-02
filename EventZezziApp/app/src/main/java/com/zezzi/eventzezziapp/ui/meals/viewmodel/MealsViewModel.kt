package com.zezzi.eventzezziapp.ui.meals.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.networking.response.Meal
import com.zezzi.eventzezziapp.networking.response.MealsResponse
import com.zezzi.eventzezziapp.ui.meals.repository.MealsRepository
import kotlinx.coroutines.launch

class MealsViewModel (val repository: MealsRepository = MealsRepository()): ViewModel() {

    private val _meals = MutableLiveData<List<Meal>>()
    val meals: LiveData<List<Meal>> = _meals

    fun fetchByCategory(category: String) {
        viewModelScope.launch {
            try {
                val meals = repository.filterByCategory(category)
                _meals.value = meals
            } catch (e: Exception) {
                Log.e("MealsViewModel", e.message.toString());
            }
        }
    }
}