package com.example.fakestore.android.presentation.screen.detail_product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.android.data.Repository
import com.example.fakestore.model.response.SingleProductResponse
import com.example.fakestore.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailProductViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    val product = MutableStateFlow<Resource<SingleProductResponse>>(Resource.Loading())
    fun getProductById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProductById(id).collect {
                product.value = it
            }
        }
    }
}