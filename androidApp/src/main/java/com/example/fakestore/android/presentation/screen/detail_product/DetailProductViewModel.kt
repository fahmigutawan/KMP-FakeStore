package com.example.fakestore.android.presentation.screen.detail_product

import androidx.lifecycle.ViewModel
import com.example.fakestore.android.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailProductViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
}