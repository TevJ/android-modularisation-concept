package com.techtev.coremodule.annotations

import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
annotation class SubscribeOn

@Qualifier
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
annotation class ObserveOn

@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AppScope

@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class MainActivityScope

@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FilmScope

@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class WeatherScope