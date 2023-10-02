package com.zezzi.eventzezziapp.ui.meals.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.zezzi.eventzezziapp.R
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.networking.response.Meal
import com.zezzi.eventzezziapp.ui.categories.view.MealsCategoriesScreen
import com.zezzi.eventzezziapp.ui.meals.viewmodel.MealsViewModel
import com.zezzi.eventzezziapp.ui.theme.EventZezziAppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsFilterScreen(navController: NavController, category: String) {
    Log.d("ARGUMENTS", category)

    val viewModel: MealsViewModel = viewModel()
    val mealFilter by viewModel.meals.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchByCategory("Beef")
    }

    Scaffold(topBar = {
        AppBar(title = "Categories", navController = navController)
    }) {
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            mealFilter?.let {
                items(it) { meal ->
                    MealCategory(meal)
                }
            }
        }
    }
}

@Composable
fun MealCategory(meal: Meal) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {
            Image(
                painter = rememberImagePainter(meal.urlImage),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.recepies_name),
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EventZezziAppTheme {
        MealsCategoriesScreen(navController = rememberNavController())
    }
}