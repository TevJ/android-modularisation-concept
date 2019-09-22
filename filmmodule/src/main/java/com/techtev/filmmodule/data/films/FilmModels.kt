package com.techtev.filmmodule.data.films

import com.squareup.moshi.JsonClass
import com.techtev.filmbinder.Film

@JsonClass(generateAdapter = true)
data class PopularFilmsResponse(
    val page: Int,
    val results: List<FilmData>
)

@JsonClass(generateAdapter = true)
data class FilmData(
    val id: Long,
    val title: String,
    val overview: String
)

fun FilmData.mapToDomain() = Film(id, title, overview)