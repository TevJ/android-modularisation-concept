package com.techtev.filmmodule.data.films

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmsApi {
    @GET("/3/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Observable<PopularFilmsResponse>
}