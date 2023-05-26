package com.felipe.data.movies

import com.google.gson.annotations.SerializedName

data class GetMoviesApiResponse(
    val results: List<ApiMovieModel>
)

data class ApiMovieModel(
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("poster_path")
    val posterPath: String
)
