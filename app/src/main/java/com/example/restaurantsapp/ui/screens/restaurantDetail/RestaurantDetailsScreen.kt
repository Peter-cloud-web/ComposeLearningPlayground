package com.example.restaurantsapp.ui.screens.restaurantDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.restaurantsapp.ui.screens.restaurantComponents.Icons.PlaceIcon
import com.example.restaurantsapp.ui.screens.restaurantComponents.RestaurantDetails
import com.example.restaurantsapp.viewModel.RestaurantDetailsViewModel

@Composable
fun RestaurantDetailsScreen(
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal
    = Alignment.Start
) {
    val viewModel: RestaurantDetailsViewModel = viewModel()

    val item = viewModel.state.value
    if (item != null) {
        Column(
            modifier = modifier,
            horizontalAlignment = horizontalAlignment
        ) {
            PlaceIcon(modifier = modifier.padding(top = 32.dp, bottom = 32.dp))

            RestaurantDetails(
                title = item.title,
                item.description,
                modifier = modifier.padding(bottom = 32.dp)
            )
            Alignment.CenterHorizontally
            Text("More info coming soon")
        }
    }
}