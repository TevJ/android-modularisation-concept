package com.techtev.modularisationconcept

import com.techtev.coremodule.di.BaseComponent
import com.techtev.coremodule.di.BaseModule
import com.techtev.coremodule.di.DaggerBaseComponent
import com.techtev.modularisationconcept.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ModularisationConcept : DaggerApplication() {

    private lateinit var baseComponent: BaseComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .baseComponent(provideBaseComponent())
            .build()
    }

    private fun provideBaseComponent(): BaseComponent {
        if (!::baseComponent.isInitialized) {
            baseComponent = DaggerBaseComponent
                .builder()
                .baseModule(BaseModule)
                .build()
        }
        return baseComponent
    }
}