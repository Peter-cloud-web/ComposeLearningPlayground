package com.example.restaurantsapp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantsapp.api.RestaurantApiService
import com.example.restaurantsapp.data.model.Restaurant
import com.example.restaurantsapp.util.FIREBASE_URL
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantDetailsViewModel(private val stateHandle:SavedStateHandle) : ViewModel() {
    private val restInterface: RestaurantApiService



    val state = mutableStateOf<Restaurant?>(null)

    private val errorHandler = CoroutineExceptionHandler{ _,exception ->
        exception.printStackTrace()

    }

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(FIREBASE_URL)
            .build()
        restInterface = retrofit.create(RestaurantApiService::class.java)

         val id = stateHandle.get<Int>("restaurant_id")?:0

        viewModelScope.launch(errorHandler) {
            val restaurant = getRemoteRestaurant(id)
            state.value = restaurant
        }
    }

    private suspend fun getRemoteRestaurant(id: Int): Restaurant {
        return withContext(Dispatchers.IO) {
            val responseMap = restInterface.getRestaurant(id)
            return@withContext responseMap.values.first()
        }
    }
}