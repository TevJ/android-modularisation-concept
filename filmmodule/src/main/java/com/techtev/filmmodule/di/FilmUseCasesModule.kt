package com.techtev.filmmodule.di

import com.techtev.filmbinder.GetFilmsUseCase
import com.techtev.filmmodule.domain.GetFilmsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class FilmUseCasesModule {
    @Binds
    abstract fun provideGetFilmsUseCase(getFilmsUseCaseImpl: GetFilmsUseCaseImpl): GetFilmsUseCase
}