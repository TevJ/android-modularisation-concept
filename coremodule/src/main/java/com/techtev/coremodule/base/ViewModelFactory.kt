package com.techtev.coremodule.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techtev.coremodule.annotations.AppScope
import com.techtev.coremodule.annotations.FilmScope
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

/*
* This ViewModel factory is injected into our fragments/activities so we can get ViewModels
 */

@Suppress("UNCHECKED_CAST")
@AppScope
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)