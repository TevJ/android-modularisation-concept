package com.techtev.filmmodule.data.Films

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmsApi {
    @GET("/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Observable<PopularFilmsResponse>
}