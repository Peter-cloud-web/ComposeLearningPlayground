package com.example.restaurantsapp.ui.screens.restaurantComponents


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurantsapp.R
import com.example.restaurantsapp.data.model.Restaurant
import com.example.restaurantsapp.ui.screens.restaurantComponents.Icons.FavoriteIcon
import com.example.restaurantsapp.ui.screens.restaurantComponents.Icons.PlaceIcon

@Composable
fun RestaurantItem(item: Restaurant) {

    val favouriteState = remember {
        mutableStateOf(false)
    }
    val icon = if (favouriteState.value)
        Icons.Filled.Favorite
    else
        Icons.Filled.FavoriteBorder


    Card(
        modifier = Modifier.padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            PlaceIcon(modifier = Modifier.weight(0.15f))

            RestaurantDetails(
                item.title,
                item.description,
                modifier = Modifier.weight(0.5f)
            )

           FavoriteIcon(icon = icon,modifier = Modifier.padding(8.dp)){
               favouriteState.value = !favouriteState.value
           }

        }
    }
}

val sampleData = Restaurant(1, "Gallitos", "We serve exquisite meals")

@Preview(showBackground = true)
@Composable
fun RestaurantItemPreview() {
    RestaurantItem(item = sampleData)
}
