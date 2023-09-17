package com.example.restaurantsapp.ui.screens.restaurantScreens


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.restaurantsapp.ui.screens.restaurantComponents.RestaurantItem
import com.example.restaurantsapp.viewModel.RestaurantViewModel
import kotlinx.coroutines.launch


@Composable
fun RestaurantScreen() {

    val viewModel : RestaurantViewModel = viewModel()
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        )
    ) {
        items(viewModel.state.value) { restaurant ->
            RestaurantItem(item = restaurant) { id ->
                viewModel.toggleFavourite(id)
            }
        }
    }
}