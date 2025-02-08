package com.example.littlelemon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.Typography

@Composable
fun MenuItemsList(
    items: List<MenuItemRoom>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            MenuItemCard(item = item)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun MenuItemCard(item: MenuItemRoom) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(0.7f)) {
                Text(
                    text = item.title,
                    style = Typography.headlineLarge
                )
                Text(
                    text = item.description,
                    style = Typography.bodyMedium,
                    maxLines = 2,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "$${item.price},00",
                    style = Typography.labelLarge,
                    color = LittleLemonColor.green
                )
            }

            GlideImage(
                model = item.image,
                contentDescription = "Image of ${item.title}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            ) {
                it
                    .centerCrop()
                    .placeholder(R.drawable.placeholder) // Make sure to add a placeholder drawable
                    .error(R.drawable.error) // Make sure to add an error drawable
            }
        }
    }
}