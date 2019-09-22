package com.techtev.coremodule.annotations

import javax.inject.Scope

@Target(AnnotationTarget.PROPERTY)
annotation class SubscribeOn

@Target(AnnotationTarget.PROPERTY)
annotation class ObserveOn

@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AppScope

@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FilmScope