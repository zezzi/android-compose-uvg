package com.zezzi.eventzezziapp.networking.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(val categories: List<Categories>)

data class Categories(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)