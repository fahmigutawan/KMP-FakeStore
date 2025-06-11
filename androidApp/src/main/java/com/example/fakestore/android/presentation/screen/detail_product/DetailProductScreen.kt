package com.example.fakestore.android.presentation.screen.detail_product

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailProductScreen(id: Int) {
    val viewModel = hiltViewModel<DetailProductViewModel>()
}