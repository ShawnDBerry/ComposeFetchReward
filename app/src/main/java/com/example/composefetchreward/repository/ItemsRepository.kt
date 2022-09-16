package com.example.composefetchreward.repository

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.composefetchreward.model.Item
import com.example.composefetchreward.network.ItemsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class ItemsRepository @Inject constructor(private val itemsService: ItemsService) {


   suspend fun getItems(): Flow<Result<SnapshotStateList<Item>?>> {
       return createFlow()
    }

    private suspend fun createFlow(): Flow<Result<SnapshotStateList<Item>?>>{
        return flow {
            val result = itemsService.getItems()
            if(result.isSuccessful){
                emit(Result.success(result.body()))
            }
        }.flowOn(Dispatchers.IO)
    }

}