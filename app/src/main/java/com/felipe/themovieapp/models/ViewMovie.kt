package com.felipe.themovieapp.models

import com.felipe.domain.movies.Movie

data class ViewMovie(
    val title: String,
    val releaseDate: String,
    val voteAverage: Float,
    val posterPath: String
)

fun Movie.toViewMovie(): ViewMovie {
    return ViewMovie(
        title, releaseDate, voteAverage, posterPath
    )
}
