package com.pmtaller2.c00402523_IvanNolasco.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.sharp.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.Text

@Composable
fun mainBottomBar(navController: NavController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            TextButton(onClick = { navController.navigate("categories") }) { Icon(Icons.Sharp.Home , contentDescription = "Inicio") }
            TextButton(onClick = { navController.navigate("search") }) { Icon(Icons.Sharp.Search , contentDescription = "Búsqueda") }
            TextButton(onClick = { navController.navigate("cart") }) { Icon(Icons.Sharp.ShoppingCart , contentDescription = "Carrito") }
        }
    }
}


