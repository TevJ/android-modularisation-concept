package com.techtev.filmmodule.domain

import com.techtev.coremodule.annotations.ObserveOn
import com.techtev.coremodule.annotations.SubscribeOn
import com.techtev.coremodule.base.Lse
import com.techtev.coremodule.base.UseCaseImpl
import com.techtev.filmbinder.Film
import com.techtev.filmbinder.GetFilmsUseCase
import com.techtev.filmmodule.data.films.FilmsRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

class GetFilmsUseCaseImpl @Inject constructor(
    private val filmsRepository: FilmsRepository,
    @SubscribeOn val subscribeScheduler: Scheduler,
    @ObserveOn val observeScheduler: Scheduler
) : UseCaseImpl<Lse<List<Film>>, Unit>(subscribeScheduler, observeScheduler), GetFilmsUseCase {

    override fun buildUseCaseObservable(args: Unit): Observable<Lse<List<Film>>> {
        return filmsRepository.getPopularFilms()
    }
}