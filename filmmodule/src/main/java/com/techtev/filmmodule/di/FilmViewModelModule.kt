package com.techtev.filmmodule.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techtev.coremodule.annotations.FilmType
import com.techtev.coremodule.base.ViewModelFactory
import com.techtev.coremodule.base.ViewModelKey
import com.techtev.filmmodule.presentation.FilmViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FilmViewModelModule {
    @Binds
    @FilmType
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FilmViewModel::class)
    internal abstract fun filmViewModel(viewModel: FilmViewModel): ViewModel
}