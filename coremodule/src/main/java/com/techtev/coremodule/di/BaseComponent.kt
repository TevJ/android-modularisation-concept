package com.techtev.coremodule.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [BaseModule::class])
interface BaseComponent {
    val retrofit: Retrofit
}