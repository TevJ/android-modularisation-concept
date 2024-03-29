package com.techtev.filmmodule.di

import com.techtev.coremodule.annotations.FilmType
import com.techtev.filmmodule.data.films.FilmsApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
class FilmDataModule {
    @Provides
    @Reusable
    fun provideFilmApi(@FilmType retrofit: Retrofit): FilmsApi = retrofit.create(FilmsApi::class.java)
}