package com.example.restaurantsapp.ui.Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun RestaurantItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(color = Color.Gray)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {

            RestaurantIcon(
                icon = Icons.Filled.Place,
                modifier = Modifier.weight(0.15f)
            )
            Text(
                text = "Quivas",
                fontWeight = FontWeight.Bold,
            )

        }

        Text(
            text = "We serve amaizing quizzines",
            fontWeight = FontWeight.Bold,
        )

    }

}