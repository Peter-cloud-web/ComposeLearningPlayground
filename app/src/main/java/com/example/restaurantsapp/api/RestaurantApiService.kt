package com.example.restaurantsapp.api

import com.example.restaurantsapp.data.model.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantApiService {

    @GET("restaurants.json")
    suspend fun getRestaurants(): List<Restaurant>
}