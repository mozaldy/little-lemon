package com.example.littlelemon

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.toLowerCase

class MenuState {
    var items by mutableStateOf<List<MenuItemRoom>>(emptyList())
    var searchPhrase by mutableStateOf("")
    var selectedCategory by mutableStateOf<String?>(null)

    fun filterItems(): List<MenuItemRoom> {
        Log.d("menuState", selectedCategory ?: "")
        return items.filter { item ->
            val matchesSearch = item.title.contains(searchPhrase, ignoreCase = true)
            val matchesCategory = selectedCategory == null || item.category == selectedCategory!!.lowercase()
            matchesSearch && matchesCategory
        }
    }
}