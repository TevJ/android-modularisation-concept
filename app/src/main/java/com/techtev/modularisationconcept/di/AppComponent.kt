package com.techtev.modularisationconcept.di

import android.app.Application
import com.techtev.coremodule.annotations.AppScope
import com.techtev.coremodule.di.BaseComponent
import com.techtev.coremodule.di.BaseModule
import com.techtev.filmmodule.di.FilmDataModule
import com.techtev.filmmodule.di.FilmUseCasesModule
import com.techtev.filmmodule.di.FilmViewModelModule
import com.techtev.modularisationconcept.ModularisationConcept
import com.techtev.weathermodule.di.WeatherDataModule
import com.techtev.weathermodule.di.WeatherUseCasesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(
    dependencies = [BaseComponent::class],
    modules = [
        AndroidInjectionModule::class,
        FilmInjectionModule::class,
        FilmUseCasesModule::class,
        FilmDataModule::class,
        FilmViewModelModule::class,
        WeatherInjectionModule::class,
        WeatherUseCasesModule::class,
        WeatherDataModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent: AndroidInjector<ModularisationConcept> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun baseComponent(baseComponent: BaseComponent): Builder
        fun build(): AppComponent
    }
}