package com.pmtaller2.c00402523_IvanNolasco.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pmtaller2.c00402523_IvanNolasco.data.Restaurant
import com.pmtaller2.c00402523_IvanNolasco.data.categories
//import com.pmtaller2.c00402523_IvanNolasco.screen.RestaurantsScreen
import com.pmtaller2.c00402523_IvanNolasco.data.restaurants
import com.pmtaller2.c00402523_IvanNolasco.screen.CategoriesScreen
import com.pmtaller2.c00402523_IvanNolasco.screen.DishListScreen
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

sealed class Screen(val route: String) {
    object CategoriesScreen: Screen("categories")
//    object RestaurantScreen: Screen("restaurants")
//object RestaurantScreen: Screen("restaurant/{restaurantId}") {
    object RestaurantScreen: Screen("restaurant") {
//        fun createRoute(restaurantId: Int) = "restaurant/$restaurantId"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CategoriesScreen.route) {
        composable(Screen.CategoriesScreen.route) {
            CategoriesScreen(navController = navController, categories = categories)
        }

//        composable(Screen.RestaurantScreen.)
        composable(Screen.RestaurantScreen.route) {
            backStackEntry ->
            val restaurantJson = backStackEntry.arguments?.getString("restaurantJson")
            val restaurant = Json.decodeFromString<Restaurant>(restaurantJson ?: "Error")
            DishListScreen(navController = navController, restaurant)
        }
//        composable(
//            route = Screen.DishScreen.route,
//            arguments = listOf(
//                navArgument("restaurant") { type = NavType.IntType }
//            )
//        ) { backStackEntry ->
//            val restaurant = backStackEntry.arguments?.getInt("restaurantId") ?: 1
////            val dishList = restaurants[restaurantId] ?: null
//            DishListScreen(
//                navController = navController,
//                restaurant = restaurant
//            )
//        }
    }
}