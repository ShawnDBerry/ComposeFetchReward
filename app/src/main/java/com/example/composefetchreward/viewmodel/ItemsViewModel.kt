package com.example.composefetchreward.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefetchreward.model.Item
import com.example.composefetchreward.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject


@HiltViewModel
class ItemsViewModel @Inject constructor(private val itemsRepository: ItemsRepository) : ViewModel() {
    private val errorMessage = mutableStateOf("")
    var items:List<Item>? by mutableStateOf(listOf())
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    init {
        getItems()
    }

    private fun getItems() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
           itemsRepository.getItems().let { response ->
               if (response.isSuccessful) {
                   val body = response.body()
                   response.body()?.sortWith(compareBy({ it.listId }, { it.id }, { it.name }))
                   response.body()?.removeAll { it.name == null || it.name == "" }
                   withContext(Dispatchers.Main) {
                    items = response.body()
                   }
               }
               else withContext(Dispatchers.Main) { onError("Error : ${response.message()}") }
           }
        }
    }


    private fun onError(message: String) { errorMessage.value = message }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}