package com.felipe.themovieapp.data

import com.felipe.themovieapp.domain.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MoviesRepository {

    fun getPopularMovies(): Flow<Movie>
}

class MoviesRepositoryImpl(
    private val moviesApi: MoviesApi
):MoviesRepository {

    override fun getPopularMovies(): Flow<Movie> {
        return flow {
            moviesApi.getPopularMovies().results.forEach {
                val movie = it.toMovie()
                emit(movie)
            }
        }
    }
}
