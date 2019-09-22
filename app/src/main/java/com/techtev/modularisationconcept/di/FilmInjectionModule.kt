package com.techtev.modularisationconcept.di

import com.techtev.coremodule.annotations.FilmScope
import com.techtev.filmmodule.di.FilmDataModule
import com.techtev.filmmodule.presentation.FilmFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FilmInjectionModule {
    @FilmScope
    @ContributesAndroidInjector(modules = [FilmDataModule::class])
    abstract fun filmFragment(): FilmFragment
}