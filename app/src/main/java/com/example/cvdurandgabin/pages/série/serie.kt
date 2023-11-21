package com.example.cvdurandgabin.pages.série

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cvdurandgabin.models.MainViewModel
import com.example.cvdurandgabin.pages.série.Components.CardSerie

@Composable
fun serie(viewModel: MainViewModel, onClick: (id : Int) -> Unit) {
    val series by viewModel.series.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = true){
        viewModel.getSerieWeek()
    }
    Box(modifier = Modifier.padding(20.dp).fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(series.size) {
                CardSerie(series[it], onClick)
            }
        }
    }
}