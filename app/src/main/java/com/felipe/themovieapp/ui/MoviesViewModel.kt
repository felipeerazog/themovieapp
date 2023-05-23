package com.felipe.themovieapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipe.themovieapp.domain.GetPopularMoviesUseCase
import com.felipe.themovieapp.domain.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MoviesUIState(
    val loading: Boolean = false,
    val movies: List<Movie>? = null
) {
    fun addMovie(movie: Movie): MoviesUIState {
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
    val moviesState: StateFlow<MoviesUIState> = _moviesState

    init {
        viewModelScope.launch {
            _moviesState.emit(
                _moviesState.value.copy(loading = true)
            )
            getPopularMoviesUseCase().collect { movie ->
                _moviesState.emit(
                    _moviesState.value.addMovie(movie)
                )
            }

        }
    }
}