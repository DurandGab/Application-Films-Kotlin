package com.example.cvdurandgabin.pages.film.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.cvdurandgabin.models.MainViewModel
import com.example.cvdurandgabin.models.TmdbMovieDetail

@Composable
fun DetailFilm(id: Int, viewModel: MainViewModel){
    val detailmovie by viewModel.detailMovie.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = true) {
        viewModel.getDetailMovie(id)
    }

    LazyColumn() {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                Card(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .fillMaxSize()
                        .background(
                            MaterialTheme.colorScheme.background,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .shadow(4.dp),
                    elevation = 0.dp,
                ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        AsyncImage(
                            model = "https://image.tmdb.org/t/p/w500/${detailmovie.poster_path}",
                            contentDescription = "Affiche Film",
                            modifier = Modifier
                                .fillMaxSize()
                                .height(400.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            detailmovie.title,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(5.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp)) // Espacement entre le nom et la date d'anniversaire
                        Text(
                            text = "Date de sortie : ${detailmovie.release_date}",
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp)) // Espacement entre la date d'anniversaire et la biographie
                        Text(
                            text = "Synopsis :",
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.Start)
                        )
                        Text(
                            text = detailmovie.overview,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
        items(detailmovie.credits.cast.size) { index ->
            TeteAfficheFilm(index, detailmovie)
            Log.d("test", detailmovie.credits.cast.size.toString())
        }
    }
}
