package com.felipe.themovieapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipe.domain.movies.GetPopularMoviesUseCase
import com.felipe.themovieapp.models.ViewMovie
import com.felipe.themovieapp.models.toViewMovie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MoviesUIState(
    val loading: Boolean = false,
    val movies: List<ViewMovie>? = null
) {
    fun addMovie(movie: ViewMovie): MoviesUIState {
        val newMovies = movies?.plus(movie) ?: listOf(movie)
        return this.copy(
            movies = newMovies,
            loading = false
        )
    }
}

class MoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _moviesState = MutableStateFlow(MoviesUIState())
    val moviesState = _moviesState.asStateFlow()

    init {

        viewModelScope.launch {
            _moviesState.update {
                it.copy(loading = true)
            }
            getPopularMoviesUseCase().collect { movie ->
                _moviesState.update {
                    it.addMovie(movie.toViewMovie())
                }
            }

        }
    }
}
