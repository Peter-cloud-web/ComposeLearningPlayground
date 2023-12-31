package com.example.restaurantsapp.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantsapp.RestaurantsApplication
import com.example.restaurantsapp.api.RestaurantApiService
import com.example.restaurantsapp.data.model.Restaurant
import com.example.restaurantsapp.db.room.RestaurantDb
import com.example.restaurantsapp.util.FIREBASE_URL
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantViewModel(
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    private var restaurantDao = RestaurantDb.getDaoInstance(RestaurantsApplication.getAppContext())
    private var restInterface: RestaurantApiService
    val state = mutableStateOf(emptyList<Restaurant>())
    private val errorHandler = CoroutineExceptionHandler{ _,exception ->
        exception.printStackTrace()

    }

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(FIREBASE_URL)
            .build()

        restInterface = retrofit.create(RestaurantApiService::class.java)

        getRestaurants()
    }

    private fun getRestaurants() {
        viewModelScope.launch(errorHandler) {
                getRemoteRestaurants().let { restaurants ->
                    state.value = restaurants
                }
            }
        }

    private suspend fun getRemoteRestaurants():List<Restaurant>{
        return withContext(Dispatchers.IO){
            val restaurants = restInterface.getRestaurants()
            Log.d("VIEW MODEL :","$restaurants")
//            restaurantDao.addAll(restaurants)
            return@withContext restaurants
        }
    }

    fun toggleFavourite(id: Int) {
        val restaurants = state.value.toMutableList()
        val itemIndex = restaurants.indexOfFirst { it.id == id }
        val item = restaurants[itemIndex]
        restaurants[itemIndex] = item.copy(isFavourite = !item.isFavourite)
        storeSelection(restaurants[itemIndex])
        state.value = restaurants

    }

    private fun storeSelection(item: Restaurant) {
        val savedToggle = stateHandle
            .get<List<Int>?>(FAVORITES)
            .orEmpty().toMutableList()
        if (item.isFavourite) savedToggle.add(item.id)
        else savedToggle.remove(item.id)
        stateHandle[FAVORITES] = savedToggle
    }

    private fun List<Restaurant>.restoreSelections(): List<Restaurant> {

        stateHandle.get<List<Int>?>(FAVORITES)?.let { selectedIds ->

            val restaurantMap = this.associateBy { it.id }

            selectedIds.forEach { id ->
                restaurantMap[id]?.isFavourite = true
            }
            return restaurantMap.values.toList()
        }
        return this
    }

    companion object {
        const val FAVORITES = "favorites"
    }
}
