package com.pmtaller2.c00402523_IvanNolasco.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
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
                title = { Text(
                    text = restaurant.name,
                    fontWeight = FontWeight.Black) },
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
                .padding(paddingValues)
        ) {  }

    }
}