package com.example.restaurantsapp.ui.screens.restaurantScreens


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.restaurantsapp.data.model.Restaurant
import com.example.restaurantsapp.data.model.RestaurantResponse
import com.example.restaurantsapp.ui.screens.restaurantComponents.RestaurantItem
import com.example.restaurantsapp.viewModel.RestaurantViewModel


@Composable
fun RestaurantScreen(restaurantResponse: RestaurantResponse) {

    val viewModel = remember {
        RestaurantViewModel(restaurantResponse)
    }

    val state: MutableState<List<Restaurant>> =
        remember {
            mutableStateOf(viewModel.getRestaurants().restaurants)
        }

    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        )
    ) {

        items(state.value) { restaurant ->
            RestaurantItem(item = restaurant) { id ->
                val restaurants = state.value.toMutableList()
                val itemIndex = restaurants.indexOfFirst {
                    it.id == id
                }

                val item = restaurants[itemIndex]

                restaurants[itemIndex] = item.copy(isFavourite = !item.isFavourite)
                state.value = restaurants
            }


        }
    }
}