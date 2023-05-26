package com.felipe.data.movies

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MoviesRepository {

    fun getPopularMovies(): Flow<ApiMovieModel>
}

class MoviesRepositoryImpl(
    private val moviesApi: MoviesApi
): MoviesRepository {

    override fun getPopularMovies(): Flow<ApiMovieModel> {
        return flow {
            moviesApi.getPopularMovies().results.forEach {
                emit(it)
            }
        }
    }
}
