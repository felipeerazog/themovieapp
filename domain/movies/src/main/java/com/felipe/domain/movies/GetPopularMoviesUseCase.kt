package com.felipe.domain.movies

import com.felipe.data.movies.ApiMovieModel
import com.felipe.data.movies.MoviesApi
import com.felipe.data.movies.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

interface GetPopularMoviesUseCase {
    operator fun invoke(): Flow<Movie>
}

class GetPopularMoviesUseCaseImpl(
    private val moviesRepository: MoviesRepository
): GetPopularMoviesUseCase {

    override fun invoke(): Flow<Movie> {
        return moviesRepository.getPopularMovies().map {
            it.toMovie()
        }
    }
}

fun ApiMovieModel.toMovie(): Movie {
    return Movie(
        title = title,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        posterPath = posterPath
    )
}
