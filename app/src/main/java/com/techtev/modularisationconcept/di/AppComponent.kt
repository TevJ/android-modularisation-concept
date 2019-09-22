package com.techtev.modularisationconcept.di

import android.app.Application
import com.techtev.coremodule.annotations.AppScope
import com.techtev.coremodule.di.BaseComponent
import com.techtev.modularisationconcept.ModularisationConcept
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(
    dependencies = [BaseComponent::class],
    modules = [AndroidInjectionModule::class, FilmInjectionModule::class]
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