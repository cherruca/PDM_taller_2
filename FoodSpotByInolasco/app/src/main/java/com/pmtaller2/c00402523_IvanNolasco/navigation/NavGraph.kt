package com.pmtaller2.c00402523_IvanNolasco.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pmtaller2.c00402523_IvanNolasco.data.Category
import com.pmtaller2.c00402523_IvanNolasco.data.Restaurant
import com.pmtaller2.c00402523_IvanNolasco.data.categories
//import com.pmtaller2.c00402523_IvanNolasco.screen.RestaurantsScreen
import com.pmtaller2.c00402523_IvanNolasco.data.restaurants
import com.pmtaller2.c00402523_IvanNolasco.screen.CategoriesScreen
import com.pmtaller2.c00402523_IvanNolasco.screen.DishListScreen
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.logging.Logger

sealed class Screen(val route: String) {
    object CategoriesScreen: Screen("categories")

    object RestaurantScreen: Screen("restaurant/{categoryId}/{restaurantId}") {
        fun createRoute(categoryId: Int, restaurantId: Int) = "restaurant/$categoryId/$restaurantId"
    }

//    object RestaurantScreen: Screen("restaurant/{restaurantId}") {
//    object RestaurantScreen: Screen("restaurant") {
//        fun createRoute(restaurantId: Restaurant) = "restaurant/$restaurantId"
//    }

}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CategoriesScreen.route) {
        composable(Screen.CategoriesScreen.route) {
            CategoriesScreen(navController = navController, categories = categories)
        }

        composable(
            route = Screen.RestaurantScreen.route,
            arguments = listOf(
                navArgument("categoryId") { type = NavType.IntType },
                navArgument("restaurantId") { type = NavType.IntType }
            )
        ) {backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 1
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 1
            val selectedCategory : Category? = categories.find { it.id == categoryId }

            if (selectedCategory != null) {
                val selectedRestaurant: Restaurant? = selectedCategory.restaurants.find { it.id == restaurantId }

                if (selectedRestaurant != null) {
                    DishListScreen(navController = navController, selectedRestaurant)
                }
            }



        }

//        composable(Screen.RestaurantScreen.route) {

//        composable("restaurant/{restaurantId}") {
//            backStackEntry ->
//            val restaurantJson = backStackEntry.arguments?.getString("restaurantJson")
//            val restaurant = Json.decodeFromString<Restaurant>(restaurantJson ?: "Error")
//            DishListScreen(navController = navController, restaurant)
//        }

    }
}