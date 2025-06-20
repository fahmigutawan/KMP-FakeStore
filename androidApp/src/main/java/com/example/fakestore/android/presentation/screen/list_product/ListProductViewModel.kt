package com.example.fakestore.android.presentation.screen.list_product

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.android.data.Repository
import com.example.fakestore.model.response.SingleBannerResponse
import com.example.fakestore.model.response.SingleProductResponse
import com.example.fakestore.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListProductViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    val products = MutableStateFlow<Resource<List<SingleProductResponse>>>(Resource.Loading())
    val banners = MutableStateFlow<Resource<List<SingleBannerResponse>>>(Resource.Loading())

    fun getProducts(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProducts().collect {
                products.value = it
            }
        }
    }

    fun getBanners(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getBanners().collect {
                banners.value = it
            }
        }
    }

    init {
        getProducts()
        getBanners()
    }
}