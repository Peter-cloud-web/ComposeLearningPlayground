package com.example.restaurantsapp.ui.screens.restaurantComponents


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurantsapp.data.model.Restaurant

@Composable
fun RestaurantItem(item: Restaurant) {
    Card(
        modifier = Modifier.padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            RestaurantIcon(
                icon = Icons.Filled.Place,
                modifier = Modifier.weight(0.15f)
            )
            RestaurantDetails(
                item.title,
                item.description,
                modifier = Modifier.weight(0.85f))

        }
    }
}

val sampleData = Restaurant(1,"Gallitos","We serve exquisite meals")
@Preview(showBackground = true)
@Composable
fun RestaurantItemPreview() {
    RestaurantItem(item = sampleData)
}
