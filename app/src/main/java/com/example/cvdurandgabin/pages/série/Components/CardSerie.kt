package com.example.cvdurandgabin.pages.série.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cvdurandgabin.models.TmdbMovie
import com.example.cvdurandgabin.models.TmdbSerie

@Composable
fun CardSerie(serie: TmdbSerie) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .shadow(4.dp)
            .padding(12.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500/${serie.poster_path}",
                contentDescription = "Affiche Film",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                serie.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(5.dp),
                textAlign = TextAlign.Center
            )
            Text(
                serie.original_name,
                textAlign = TextAlign.Center
            )
        }
    }
}