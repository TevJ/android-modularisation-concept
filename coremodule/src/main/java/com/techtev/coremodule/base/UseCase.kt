package com.techtev.coremodule.base

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import java.util.concurrent.Executor

interface UseCase<T, Args>

abstract class UseCaseImpl<T, Args>(
    private val subscribeScheduler: Scheduler,
    private val observeScheduler: Scheduler
) : UseCase<T, Args> {
    private val compositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(args: Args): Observable<T>

    fun execute(observer: DisposableObserver<T>, args: Args) {
        val observable = buildUseCaseObservable(args)
            .subscribeOn(subscribeScheduler)
            .observeOn(observeScheduler)
        compositeDisposable.add(observable.subscribeWith(observer))
    }

    fun dispose() = compositeDisposable.dispose()
}