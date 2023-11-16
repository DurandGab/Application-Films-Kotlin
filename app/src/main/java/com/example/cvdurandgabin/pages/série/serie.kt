package com.example.cvdurandgabin.pages.série

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cvdurandgabin.models.MainViewModel
import com.example.cvdurandgabin.pages.série.Components.CardSerie

@Composable
fun serie(viewModel: MainViewModel) {
    val series by viewModel.series.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = true){
        viewModel.getSerieWeek()
    }
    LazyColumn() {
        items(series.size) {
            CardSerie(series[it])
        }
    }
}