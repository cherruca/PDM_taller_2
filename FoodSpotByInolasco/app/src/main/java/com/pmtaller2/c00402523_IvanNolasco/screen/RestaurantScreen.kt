package com.pmtaller2.c00402523_IvanNolasco.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Text(
                text = restaurant.description,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp
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
        val context = LocalContext.current
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
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
                    modifier = Modifier.size(300.dp),
                    error = painterResource(id = R.drawable.ic_launcher_foreground)
                )

                Text(
                    text = dish.name,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = dish.description,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier
                        .size(10.dp)
                )

                Button(
                    onClick = {
                        Toast.makeText(context, "Se agregó ${dish.name} a su carretilla", Toast.LENGTH_LONG).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(text = "Comprar",
                        color = Color.Yellow)
                }

            }

        }
    }