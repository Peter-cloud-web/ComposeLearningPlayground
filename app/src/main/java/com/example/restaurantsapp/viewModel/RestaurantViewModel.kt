package com.example.restaurantsapp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.restaurantsapp.data.model.RestaurantResponse

class RestaurantViewModel(private val restaurantResponse: RestaurantResponse) : ViewModel() {

    val state = mutableStateOf(restaurantResponse.restaurants)

    fun toggleFavourite(id: Int) {
        val restaurants = state.value.toMutableList()
        val itemIndex = restaurants.indexOfFirst { it.id == id }
        val item = restaurants[itemIndex]
        restaurants[itemIndex] = item.copy(isFavourite = !item.isFavourite)
        state.value = restaurants

    }

    fun getRestaurants(): RestaurantResponse {
        return restaurantResponse
    }
}