package com.example.restaurantsapp.ui.screens.restaurantComponents.Icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
    icon: ImageVector,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Image(
        imageVector = icon,
        contentDescription = "Favorite restaurant icon",
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() }
    )
}