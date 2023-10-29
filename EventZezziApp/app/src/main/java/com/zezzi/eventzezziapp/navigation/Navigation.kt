package com.zezzi.eventzezziapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zezzi.eventzezziapp.ui.categories.view.MealsCategoriesScreen
import com.zezzi.eventzezziapp.ui.concerts.view.ConcertsView
import com.zezzi.eventzezziapp.ui.detail.view.DetailView
import com.zezzi.eventzezziapp.ui.favorites.view.FavoritesView
import com.zezzi.eventzezziapp.ui.meals.view.MealsFilterScreen
import com.zezzi.eventzezziapp.ui.profile.view.ProfileView
import com.zezzi.eventzezziapp.ui.venues.view.VenuesView

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.MealsCategories.route,
        modifier = modifier) {
        composable(route = NavigationState.MealsCategories.route) {
            MealsCategoriesScreen(navController = navController)
        }
        composable(NavigationState.MealsRecepiesList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val categoryName = arguments.getString("category") ?: ""
            Log.d("ARGUMENTNAV", categoryName)
            MealsFilterScreen(navController = navController, category = categoryName)
        }
        composable(route = NavigationState.Home.route) {
            ConcertsView(navController = navController)
        }
        composable(route = NavigationState.Detail.route) {
            VenuesView(navController = navController)
        }
        composable(route = NavigationState.Events.route) {
            DetailView(navController = navController)
        }
        composable(route = NavigationState.Profile.route) {
            ProfileView(navController = navController)
        }
        composable(route = NavigationState.Profile.route) {
            FavoritesView(navController = navController)
        }
    }
}