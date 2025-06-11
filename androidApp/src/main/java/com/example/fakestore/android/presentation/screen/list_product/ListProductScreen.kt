package com.example.fakestore.android.presentation.screen.list_product

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import com.example.fakestore.util.Resource
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListProductScreen(
    onProductClick: (id: Int) -> Unit,
) {
    val viewModel = hiltViewModel<ListProductViewModel>()
    val products = viewModel.products.collectAsStateWithLifecycle()
    val banners = viewModel.banners.collectAsStateWithLifecycle()
    val bannerPagerState = rememberPagerState { banners.value.data?.size ?: 0 }

    LaunchedEffect(true) {
        while (true) {
            if (!bannerPagerState.isScrollInProgress) {
                delay(3000)
                if (bannerPagerState.canScrollForward) {
                    bannerPagerState.animateScrollToPage(bannerPagerState.currentPage + 1)
                } else {
                    bannerPagerState.animateScrollToPage(0)
                }
            }
        }
    }

    Scaffold {
        when (products.value) {
            is Resource.Error -> {

            }

            is Resource.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(32.dp),
                        strokeWidth = 4.dp
                    )
                }
            }

            is Resource.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item(span = { GridItemSpan(2) }) {
                        Spacer(Modifier)
                    }

                    item(span = { GridItemSpan(2) }) {
                        HorizontalPager(
                            state = bannerPagerState,
                            beyondViewportPageCount = 2,
                            pageSpacing = (-24).dp
                        ) {
                            val item = banners.value.data?.get(it)

                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            ) {
                                AsyncImage(
                                    model = item?.image ?: "",
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(16f / 8f),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }

                    products.value.data?.forEach { _item ->
                        item {
                            ElevatedCard(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                onClick = {
                                    onProductClick(_item.id)
                                },
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 2.dp
                                )
                            ) {
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(120.dp)
                                            .background(Color.White),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        AsyncImage(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(16.dp),
                                            model = _item.image,
                                            contentScale = ContentScale.Fit,
                                            contentDescription = ""
                                        )
                                    }

                                    Text(
                                        _item.title,
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.SemiBold,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier
                                            .padding(12.dp)
                                    )
                                }
                            }
                        }
                    }

                    item(span = { GridItemSpan(2) }) {
                        Spacer(Modifier)
                    }
                }
            }
        }
    }
}