package com.felipe.themovieapp.data

import com.felipe.themovieapp.domain.Movie
import com.google.gson.annotations.SerializedName

data class GetMoviesApiResponse(
    val results: List<ApiMovieModel>
)

data class ApiMovieModel(
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String
) {
    fun toMovie():Movie{
        return Movie(
            title = originalTitle,
            overview = overview
        )
    }
}
