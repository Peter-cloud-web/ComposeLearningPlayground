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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
//                    RestaurantScreen()
//                    RestaurantDetailsScreen()
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
                RestaurantScreen()
            }
            composable(route = "restaurants/{restaurant_id}"){
                RestaurantDetailsScreen()
            }

        }

    }
}


