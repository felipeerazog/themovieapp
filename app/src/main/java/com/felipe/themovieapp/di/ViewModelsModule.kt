package com.felipe.themovieapp.di

import androidx.lifecycle.ViewModel
import com.felipe.themovieapp.ui.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityComponent::class)
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMMoviesViewModel(viewModel: MoviesViewModel): ViewModel
}