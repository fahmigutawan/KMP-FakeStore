package com.example.fakestore.android.presentation.screen.detail_product

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailProductScreen(id: Int) {
    val viewModel = hiltViewModel<DetailProductViewModel>()
    val product = viewModel.product.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.getProductById(id)
    }
}