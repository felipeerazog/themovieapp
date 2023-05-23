package com.felipe.themovieapp.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felipe.themovieapp.ui.theme.TheMovieAppTheme

@Composable
fun MoviesScreen(moviesUIState: MoviesUIState) {
    when {
        moviesUIState.loading -> LoadingMovies()
        moviesUIState.movies != null -> MoviesList(movies = moviesUIState.movies)
    }
}

@Composable
fun LoadingMovies() {
    CircularProgressIndicator(
        modifier = Modifier.size(48.dp)
    )
}

@Composable
@Preview
fun MoviesScreenLoadingPreview(){
    TheMovieAppTheme {
        MoviesScreen(moviesUIState = MoviesUIState(loading = true))
    }
}