package com.techtev.modularisationconcept.di

import com.techtev.coremodule.annotations.AppScope
import com.techtev.coremodule.annotations.MainActivityScope
import com.techtev.modularisationconcept.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @MainActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}