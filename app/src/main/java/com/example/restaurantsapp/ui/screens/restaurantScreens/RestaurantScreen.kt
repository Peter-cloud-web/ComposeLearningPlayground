package com.example.restaurantsapp.ui.screens.restaurantScreens


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.restaurantsapp.data.model.RestaurantResponse
import com.example.restaurantsapp.ui.screens.restaurantComponents.RestaurantItem


@Composable
fun RestaurantScreen(restaurantsList: RestaurantResponse) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        )
    ) {
        items(restaurantsList.restaurants){restaurant ->
            RestaurantItem(item = restaurant)

        }
    }
}