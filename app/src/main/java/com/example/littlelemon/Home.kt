package com.example.littlelemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun HomeScreen(navController: NavHostController, database: AppDatabase) {
    val menuState = remember { MenuState() }
    val menuItems by database.menuItemDao().getAllMenuItems().observeAsState(emptyList())


    LaunchedEffect(Unit) {
        menuState.items = menuItems
        Log.d("db items", menuState.items.toString())
    }

    LaunchedEffect(menuItems) {
        menuState.items = menuItems
        Log.d("HomeScreen", "Menu Items Updated. Count: ${menuItems.size}")
        menuItems.forEach { item ->
            Log.d("HomeScreen", "Menu Item: ${item.title}, Category: ${item.category}")
        }

        if (menuItems.isEmpty()) {
            Log.w("HomeScreen", "Warning: Menu items list is empty!")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 20.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.Center)
            )

            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterEnd)
                    .border(2.dp, LittleLemonColor.green, CircleShape)
                    .clickable {
                        navController.navigate(Profile.route)
                    }
            )

        }
        UpperPanel(
            searchPhrase = menuState.searchPhrase,
            onSearchPhraseChange = { menuState.searchPhrase = it }
        )

        LowerPanel(
            selectedCategory = menuState.selectedCategory,
            onCategorySelected = { menuState.selectedCategory = it },
            items = menuState.filterItems(),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}