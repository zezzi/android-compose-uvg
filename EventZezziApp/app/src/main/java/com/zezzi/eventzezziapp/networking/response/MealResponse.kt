package com.zezzi.eventzezziapp.networking.response

import com.google.gson.annotations.SerializedName

data class MealsResponse(val categories: List<Meals>)

data class Meals(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val urlImage: String
)