package com.felipe.themovieapp.di

import com.felipe.themovieapp.data.MoviesApi
import com.felipe.themovieapp.data.MoviesRepository
import com.felipe.themovieapp.data.MoviesRepositoryImpl
import com.felipe.themovieapp.domain.GetPopularMoviesUseCase
import com.felipe.themovieapp.domain.GetPopularMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object MoviesModule {

    @Provides
    fun provideMoviesApi(
        retrofit: Retrofit
    ): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Provides
    fun provideMoviesRepository(
        moviesApi: MoviesApi
    ): MoviesRepository {
        return MoviesRepositoryImpl(moviesApi)
    }

    @Provides
    fun provideGetPopularMoviesUseCase(
        moviesRepository: MoviesRepository
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(moviesRepository)
    }
}
