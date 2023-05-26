package com.felipe.themovieapp.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.felipe.themovieapp.R
import com.felipe.themovieapp.models.ViewMovie
import com.felipe.themovieapp.ui.theme.TheMovieAppTheme
import com.skydoves.landscapist.glide.GlideImage

const val IMAGES_BASE_URL = "https://www.themoviedb.org/t/p/original"

@Composable
fun MoviesList(movies: List<ViewMovie>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(movies) { movie ->
                MovieItem(movie = movie)
            }
        }
    )
}

@Composable
fun MovieItem(movie: ViewMovie) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        GlideImage(
            imageModel = { "$IMAGES_BASE_URL${movie.posterPath}" },
            previewPlaceholder = R.drawable.ic_launcher_foreground,
            modifier = Modifier
                .fillMaxWidth()
                .clip(CardDefaults.shape),
            requestOptions = {
                RequestOptions().fitCenter()
            }
        )
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
                .offset(y = (-16).dp)
        ) {
            RateIndicator(
                rate = movie.voteAverage,
                modifier = Modifier
            )
            Text(
                text = movie.title,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = movie.releaseDate,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun RateIndicator(
    rate: Float,
    modifier: Modifier
) {
    val sweepAngle = rate * 360 / 10
    val indicatorColor = if (rate >= 7f) {
        Color.Green
    } else {
        Color.Yellow
    }
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color.Black)
            .padding(2.dp)
            .size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawArc(
                color = indicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 4f, cap = StrokeCap.Round),
            )
        }
        Text(
            text = rate.toString(),
            color = Color.White,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
@Preview
fun MoviesGridPreview() {
    val movie1 = ViewMovie(
        title = "The Super Mario Bros. Movie",
        releaseDate = "2023-04-05",
        voteAverage = 7.7f,
        posterPath = "/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg"
    )
    val movie2 = ViewMovie(
        title = "Terminator",
        releaseDate = "2023-04-05",
        voteAverage = 5.5f,
        posterPath = "/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg"
    )
    TheMovieAppTheme {
        MoviesList(movies = listOf(movie1, movie2, movie1))
    }
}