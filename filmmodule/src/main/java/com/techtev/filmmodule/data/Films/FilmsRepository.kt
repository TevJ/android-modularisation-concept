package com.techtev.filmmodule.data.Films

import com.techtev.coremodule.base.Lse
import com.techtev.filmbinder.Film
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

const val API_KEY = ""

class FilmsRepository @Inject constructor(private val filmsApi: FilmsApi) {

    fun getPopularFilms(): Observable<Lse<List<Film>>> {
        return filmsApi.getPopularMovies(API_KEY)
            .map<Lse<List<Film>>> { Lse.Success(it.results.map { filmData -> filmData.mapToDomain() }) }
            .onErrorReturn { e -> Lse.Error(e) }
            .startWithItem(Lse.Loading())
    }
}