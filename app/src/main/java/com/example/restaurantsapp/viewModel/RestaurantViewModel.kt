package com.example.restaurantsapp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.restaurantsapp.data.model.Restaurant
import com.example.restaurantsapp.data.model.restaurantList

class RestaurantViewModel(
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    val state = mutableStateOf(restaurantList.restoreSelections())

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

            val restaurantMap = this.associateBy {it.id}

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