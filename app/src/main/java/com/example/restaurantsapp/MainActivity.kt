package com.example.restaurantsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.restaurantsapp.ui.screens.restaurantDetail.RestaurantDetailsScreen
import com.example.restaurantsapp.ui.screens.restaurantScreens.RestaurantScreen
import com.example.restaurantsapp.ui.theme.RestaurantsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RestaurantApp()
                }
            }
        }
    }

    @Composable
    private fun RestaurantApp(){
        val navController = rememberNavController()
        NavHost(navController, startDestination = "restaurants" ){
            composable(route = "restaurants"){
                RestaurantScreen{id ->
                    navController.navigate("restaurants/$id")
                }
            }
            composable(route = "restaurants/{restaurant_id}",
            arguments = listOf(navArgument("restaurant_id"){
              type = NavType.IntType
            })

            ) { navStackEntry ->
                val id = navStackEntry.arguments?.getInt("restaurant_id")
                RestaurantDetailsScreen()
            }

        }

    }
}


