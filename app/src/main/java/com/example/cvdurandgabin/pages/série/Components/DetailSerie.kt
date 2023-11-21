package com.example.cvdurandgabin.pages.série.Components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.cvdurandgabin.models.MainViewModel

@Composable
fun DetailSerie(id: Int, viewModel: MainViewModel) {
    val detailserie by viewModel.detailSerie.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = true) {
        viewModel.getDetailSerie(id)
    }
    LazyColumn(){
        item{
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)

            ) {
                Card(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small)
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
                            model = "https://image.tmdb.org/t/p/w500/${detailserie.poster_path}",
                            contentDescription = "Affiche Film",
                            modifier = Modifier
                                .fillMaxSize()
                                .height(400.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            detailserie.name,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(5.dp)


                        )
                        Text(
                            detailserie.first_air_date,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

}