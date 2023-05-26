package com.felipe.data.movies

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("sort_by") sortBy: String="popularity.desc",
        @Query("api_key") apiKey: String = BuildConfig.WEB_API_KEY // todo: try to use an interceptor for this
    ): GetMoviesApiResponse
}
