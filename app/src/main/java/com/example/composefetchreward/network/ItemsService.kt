package com.example.composefetchreward.network

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.composefetchreward.model.Item
import retrofit2.Response
import retrofit2.http.GET

interface ItemsService {
    @GET("hiring.json")
    suspend fun getItems(): Response<SnapshotStateList<Item>>
}