package com.example.composefetchreward.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.composefetchreward.composables.ItemCardList
import com.example.composefetchreward.ui.theme.ComposeFetchRewardTheme
import com.example.composefetchreward.viewmodel.ItemsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ItemsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                setContent {
                    ComposeFetchRewardTheme(darkTheme = true) {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            viewModel.items?.let { ItemCardList(items = it) }
                        }
                    }
                }
            }
        }
    }
}