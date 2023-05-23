package com.felipe.themovieapp.domain

import com.felipe.themovieapp.data.MoviesRepository
import kotlinx.coroutines.flow.Flow

interface GetPopularMoviesUseCase {
    operator fun invoke(): Flow<Movie>
}

class GetPopularMoviesUseCaseImpl(
    private val moviesRepository: MoviesRepository
):GetPopularMoviesUseCase {

    override fun invoke(): Flow<Movie> {
        return moviesRepository.getPopularMovies()
    }
}
