package com.example.restaurantsapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.restaurantsapp.data.model.RestaurantResponse

class RestaurantViewModel(private val restaurantResponse: RestaurantResponse) : ViewModel() {

    fun getRestaurants(): RestaurantResponse {
        return restaurantResponse
    }
}