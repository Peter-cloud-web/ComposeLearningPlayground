package com.example.restaurantsapp.data.model

data class Restaurant(
    val id: Int,
    val title: String,
    val description: String,
    var isFavourite:Boolean = false
)
