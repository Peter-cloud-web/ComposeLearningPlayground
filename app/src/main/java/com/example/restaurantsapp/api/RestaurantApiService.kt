package com.example.restaurantsapp.api

import com.example.restaurantsapp.data.model.RestaurantsResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantApiService {

    @GET("/restaurants.json")
    fun getRestaurants(): Response<RestaurantsResponse>
}