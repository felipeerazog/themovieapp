package com.felipe.themovieapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.felipe.themovieapp.domain.Movie

@Composable
fun MoviesList(movies: List<Movie>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        content = {
            items(movies) { movie ->
                MovieItem(movie = movie)
            }
        }
    )
}

@Composable
fun MovieItem(movie: Movie) {
    Card {
        Column {
            Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
            Text(text = movie.overview, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
