package com.pmtaller2.c00402523_IvanNolasco.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.pmtaller2.c00402523_IvanNolasco.R
import com.pmtaller2.c00402523_IvanNolasco.data.Dish
import com.pmtaller2.c00402523_IvanNolasco.data.Restaurant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishListScreen(
    navController: NavController? = null,
    restaurant: Restaurant
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.Yellow,
                ),
                title = {
                    Text(
                        text = restaurant.name,
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
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues).padding(16.dp)
        ) {
            Text(
                text = restaurant.description
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                items(restaurant.menu) { menuItem ->
                    DishCard(dish = menuItem) {

                    }
                }
            }

        }
    }
}

    @Composable
    fun DishCard(dish: Dish, onDishClick: (Int) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable { onDishClick(dish.id) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = dish.imageUrl,
                contentDescription = dish.name,
                modifier = Modifier.size(150.dp),
                error = painterResource(id = R.drawable.ic_launcher_foreground)
            )

            Text(
                text = dish.name,
            )
        }
    }