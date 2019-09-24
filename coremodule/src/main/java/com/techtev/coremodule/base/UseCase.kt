package com.techtev.coremodule.base

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import java.util.concurrent.Executor

interface UseCase<T, Args> {
    fun execute(
        onNext: (T) -> Unit,
        onComplete: () -> Unit,
        onError: (exception: Throwable?) -> Unit,
        args: Args
    )
    fun dispose()
}

abstract class UseCaseImpl<T, Args>(
    private val subscribeScheduler: Scheduler,
    private val observeScheduler: Scheduler
) : UseCase<T, Args> {
    private val compositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(args: Args): Observable<T>

    final override fun execute(
        onNext: (T) -> Unit,
        onComplete: () -> Unit,
        onError: (exception: Throwable?) -> Unit,
        args: Args
    ) {
        val observer = object : DisposableObserver<T>() {
            override fun onComplete() {
                onComplete()
            }

            override fun onNext(t: T) {
                onNext(t)
            }

            override fun onError(e: Throwable?) {
                onError(e)
            }
        }
        val observable = buildUseCaseObservable(args)
            .subscribeOn(subscribeScheduler)
            .observeOn(observeScheduler)
        compositeDisposable.add(observable.subscribeWith(observer))
    }

    final override fun dispose() = compositeDisposable.dispose()
}