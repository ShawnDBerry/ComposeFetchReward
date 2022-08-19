package com.example.composefetchreward.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.composefetchreward.model.Item

@Composable
fun ItemList(items: List<Item>) {
    LazyColumn {
        itemsIndexed(items = items) { _, item ->
            ItemCard(item = item)
        }
    }
}
