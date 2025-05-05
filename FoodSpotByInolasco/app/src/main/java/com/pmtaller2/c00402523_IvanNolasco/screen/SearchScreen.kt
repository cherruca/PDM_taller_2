package com.pmtaller2.c00402523_IvanNolasco.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pmtaller2.c00402523_IvanNolasco.data.Category
import com.pmtaller2.c00402523_IvanNolasco.data.Restaurant
import com.pmtaller2.c00402523_IvanNolasco.data.categories
import com.pmtaller2.c00402523_IvanNolasco.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {

    var search by remember { mutableStateOf("") }

    var filteredResults = mutableListOf<Restaurant>()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.Yellow,
                ),
                title = {
                    Text(
                        text = "Búsqueda",
                        fontWeight = FontWeight.Black
                    )
                },
                navigationIcon = {
                    navController.let {
                        IconButton(onClick = {
                            if (navController != null) {
                                navController.popBackStack()
                            }
                        }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Regresar")
                        }
                    }
                }
            )
        },
        bottomBar = {
            if (navController != null) {
                mainBottomBar(navController)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues).padding(16.dp)
        ) {

            TextField(
                value = search,
                onValueChange = { search = it
                                filteredResults.clear()
                                },
                label = { Text("Buscar") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.size(10.dp)
            )

            var mensaje: String
            if (search != "") {
                mensaje = "Resultados de ${search}"

//                filteredResults = categories.mapNotNull { item ->
//                    item.takeIf { it.name.contains(search, ignoreCase = true)
//                    } ?: item.restaurants.filter {
//                        it.name.contains(search, ignoreCase = true)
//                    }.ifEmpty { null }?.let { item.copy(restaurants = it) }
//                }

                categories.forEach { thisCategory ->
                    val restaurants = thisCategory.restaurants
                    restaurants.forEach { thisRestaurant ->
                        val foundMenu = thisRestaurant.menu.filter { it.name.contains(search, ignoreCase = true)  }
                        val foundCategory = thisRestaurant.categories.filter { it.contains(search, ignoreCase = true) }
                        if (foundMenu.isNotEmpty() || foundCategory.isNotEmpty()) {
                            filteredResults.add(thisRestaurant)
                        }
                    }

                }
            } else {
                mensaje = "Aquí apareceran los resultados..."
            }

            Text(
                text = mensaje,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp
            )

            if (!filteredResults.isEmpty()) {
                LazyColumn {

                    items(filteredResults) { item ->
                        Text(
                            text = "Restaurante: ${item.name}"
                        )

                        var fatherCategory: Int = 0

                        categories.forEach { thisCategory ->
                            var searchingCategory = thisCategory.restaurants.filter { thisRestaurant ->
                                thisRestaurant.id == item.id
                            }
                            if (!searchingCategory.isEmpty()) {
                                fatherCategory = thisCategory.id
                            }

                        }
                        RestaurantCard(item, fatherCategory) { restaurantId ->
                            navController.navigate(Screen.RestaurantScreen.createRoute(fatherCategory, item.id))

                        }

                        Spacer(
                            modifier = Modifier.size(10.dp)
                        )
                    }
                }

            }

        }
    }
}
