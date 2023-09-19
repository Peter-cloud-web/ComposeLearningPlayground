package com.example.restaurantsapp.api

import com.example.restaurantsapp.data.model.Restaurant
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantApiService {

    @GET("restaurants.json")
    suspend fun getRestaurants(): List<Restaurant>

    @GET("restaurants.json?orderBy=\"r_id\"")
    suspend fun getRestaurant(
        @Query("equalTo") id: Int
    ): Map<String, Restaurant>

}