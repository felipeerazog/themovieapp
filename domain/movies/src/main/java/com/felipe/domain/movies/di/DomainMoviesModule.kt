package com.felipe.domain.movies.di

import com.felipe.data.movies.MoviesRepository
import com.felipe.domain.movies.GetPopularMoviesUseCase
import com.felipe.domain.movies.GetPopularMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object DomainMoviesModule {

    @Provides
    fun provideGetPopularMoviesUseCase(
        moviesRepository: MoviesRepository
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(moviesRepository)
    }
}
