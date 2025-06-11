package com.example.fakestore.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fakestore.android.presentation.screen.list_product.ListProductScreen

@Composable
fun MainNavHost(
    modifier:Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "list_product"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ){
        composable("list_product") {
            ListProductScreen()
        }
    }
}