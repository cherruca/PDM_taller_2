package com.pmtaller2.c00402523_IvanNolasco.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


import com.pmtaller2.c00402523_IvanNolasco.data.Restaurant
import com.pmtaller2.c00402523_IvanNolasco.R
import com.pmtaller2.c00402523_IvanNolasco.data.Category

import com.pmtaller2.c00402523_IvanNolasco.navigation.Screen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(navController: NavController, categories: List<Category>) {
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.Yellow,
                ),
                title = { Text(
                    text ="FoodSpot by Inolasco",
                    fontWeight = FontWeight.Black) }
            )
        }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues).padding(16.dp)

        ) {
            Text(
                text = "Categorías",
                fontWeight = FontWeight.Black,
                fontSize = 24.sp
            )

            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(categories) { category ->
                    Text(
                        text = category.name,
                        fontWeight = FontWeight.Bold
                    )
                    LazyRow(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(16.dp)
                    ) { items(category.restaurants) { restaurant ->
                            RestaurantCard(restaurant = restaurant) { restaurantId ->
//                                navController.navigate(Screen.)
                            }
                        }

                    }

                }
            }

//            Snackbar()
        }
    }
}

@Composable
fun CategoryList(category: Category) {

}

@Composable
fun RestaurantCard(restaurant: Restaurant, onRestaurantClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onRestaurantClick(Json.encodeToString<Restaurant>(restaurant)) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = restaurant.imageUrl,
            contentDescription = restaurant.name,
            modifier = Modifier.size(150.dp),
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )

        Text(
            text = restaurant.name,
        )
//        Text(
//            text = restaurant.description,
//        )
    }
}