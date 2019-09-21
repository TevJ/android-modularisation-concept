package com.techtev.filmmodule.di

import com.techtev.filmmodule.data.Films.FilmsApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
class FilmDataModule {
    @Provides
    @Reusable
    fun provideFilmApi(retrofit: Retrofit) = retrofit.create(FilmsApi::class.java)
}