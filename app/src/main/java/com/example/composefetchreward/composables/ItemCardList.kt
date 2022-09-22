package com.example.composefetchreward.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.composefetchreward.model.Item

@Composable
fun ItemCardList(items: List<Item>) {
    LazyColumn {
        itemsIndexed(items = items) { _, item ->
            ItemCard(item = item)
        }
    }
}
