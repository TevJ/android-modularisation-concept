package com.techtev.coremodule.base

sealed class Lse<T> {
    class Loading<T> : Lse<T>()
    data class Success<T>(val data: T) : Lse<T>()
    data class Error<T>(val e: Throwable, val data: T? = null) : Lse<T>()
}