package com.techtev.coremodule.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class BaseModule {
    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}