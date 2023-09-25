package com.example.restaurantsapp.ui.screens.restaurantScreens


import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.restaurantsapp.ui.screens.restaurantComponents.RestaurantItem
import com.example.restaurantsapp.viewModel.RestaurantViewModel


@Composable
fun RestaurantScreen(onItemClick: (id: Int) -> Unit) {

    val viewModel: RestaurantViewModel = viewModel()
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        )
    ) {
        items(viewModel.state.value) { restaurant ->
            RestaurantItem(
                item = restaurant,
                onFavoriteClick = { id -> viewModel.toggleFavourite(id) },
                onItemClick = { id ->
                    onItemClick(id)
                    Log.d("Clicked ID : " ,"${id}")
                })
        }
    }
}