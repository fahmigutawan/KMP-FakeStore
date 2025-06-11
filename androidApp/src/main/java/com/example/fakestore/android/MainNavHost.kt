package com.example.fakestore.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fakestore.android.presentation.screen.detail_product.DetailProductScreen
import com.example.fakestore.android.presentation.screen.list_product.ListProductScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "list_product",
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("list_product") {
            ListProductScreen(
                onProductClick = {
                    navController.navigate("detail_product/$it")
                }
            )
        }

        composable(
            "detail_product/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("id") ?: 0

            DetailProductScreen(id)
        }
    }
}