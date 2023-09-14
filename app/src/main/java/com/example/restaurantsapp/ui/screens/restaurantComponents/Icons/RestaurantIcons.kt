package com.example.restaurantsapp.ui.screens.restaurantComponents.Icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PlaceIcon(
    modifier: Modifier
) {
    Image(
        imageVector = Icons.Filled.Place,
        contentDescription = "Restaurant icon",
        modifier = modifier.padding(8.dp)
    )

}

@Composable
fun FavoriteIcon(
    modifier: Modifier
) {
    val favouriteState = remember {
        mutableStateOf(false)
    }

    val icon = if (favouriteState.value)
        Icons.Filled.Favorite
    else
        Icons.Filled.FavoriteBorder

    Image(
        imageVector = icon,
        contentDescription = "Favorite restaurant icon",
        modifier = modifier.padding(8.dp)
    )
}