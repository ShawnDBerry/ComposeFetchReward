package com.example.composefetchreward.repository

import com.example.composefetchreward.network.ItemsService
import javax.inject.Inject

class ItemsRepository @Inject constructor(private val itemsService: ItemsService) {
    suspend fun getItems() = itemsService.getItems()
}