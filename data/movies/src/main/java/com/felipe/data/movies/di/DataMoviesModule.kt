package com.felipe.data.movies.di

import com.felipe.data.movies.MoviesApi
import com.felipe.data.movies.MoviesRepository
import com.felipe.data.movies.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object DataMoviesModule {

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
}
