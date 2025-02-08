package com.example.littlelemon

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ElevatedButton
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.Typography
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun LowerPanel(
    selectedCategory: String?,
    onCategorySelected: (String?) -> Unit,
    items: List<MenuItemRoom>,
    modifier: Modifier = Modifier
) {
    val categories = listOf("Starters", "Mains", "Desserts", "Drinks")

    Column(
        modifier = modifier.padding(vertical = 24.dp, horizontal = 16.dp)
    ) {
        Text(text = "ORDER FOR DELIVERY!", style = Typography.headlineLarge)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            categories.forEach { category ->
                ElevatedButton(
                    onClick = {
                        onCategorySelected(
                            if (selectedCategory == category) null else category
                        )
                    },
                    modifier = Modifier
                        .padding(top = 4.dp, bottom = 4.dp, end = 20.dp)
                ) {
                    Text(
                        text = category,
                        style = Typography.bodyLarge.copy(
                            color = if (selectedCategory == category)
                                LittleLemonColor.green
                            else
                                LittleLemonColor.charcoal
                        )
                    )
                }
            }
        }

        MenuItemsList(
            items = items,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}