package com.example.restaurantsapp.db.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.restaurantsapp.data.model.Restaurant

interface RestaurantDao {

    @Query("SELECT * FROM restaurants")
    suspend fun getAll():List<Restaurant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(restaurant: List<Restaurant>)
}