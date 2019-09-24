package com.techtev.filmmodule.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techtev.coremodule.base.Lse
import com.techtev.filmbinder.Film
import com.techtev.filmbinder.GetFilmsUseCase
import com.techtev.weatherbinder.GetWeatherForCityUseCase
import com.techtev.weatherbinder.Weather
import io.reactivex.rxjava3.observers.DisposableObserver
import javax.inject.Inject

class FilmViewModel @Inject constructor(
    private val getFilmsUseCase: GetFilmsUseCase,
    private val getWeatherForCityUseCase: GetWeatherForCityUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<FilmViewState>()
    val viewState: LiveData<FilmViewState> = _viewState

    fun onScreenStart() {
        _viewState.value = FilmViewState()
        getWeather()
        getFilms()
    }

    private fun getWeather() {
        getWeatherForCityUseCase.execute(
            args = "London",
            onNext = { weatherLse ->
                when (weatherLse) {
                    is Lse.Loading -> {
                        _viewState.value = _viewState.value?.copy(shouldShowLoadingState = true)
                    }
                    is Lse.Success -> {
                        _viewState.value = _viewState.value?.copy(
                            weatherTitle = weatherLse.data.title,
                            weatherDescription = weatherLse.data.description
                        )
                    }
                    is Lse.Error -> {
                        // TODO
                    }
                }
            },
            onComplete = { _viewState.value = _viewState.value?.copy(shouldShowLoadingState = false) },
            onError = { exception ->
                // TODO
            }
        )
    }

    private fun getFilms() {
        getFilmsUseCase.execute(
            args = Unit,
            onNext = { filmsLse ->
                when (filmsLse) {
                    is Lse.Loading -> {
                        // TODO
                    }
                    is Lse.Success -> {
                        _viewState.value = viewState.value?.copy(
                            popularFilms = filmsLse.data
                        )
                    }
                    is Lse.Error -> {
                        // TODO
                    }
                }
            },
            onComplete = {
                // TODO
            },
            onError = {
                // TODO
            }
        )
    }

    override fun onCleared() {
        getFilmsUseCase.dispose()
        getWeatherForCityUseCase.dispose()
        super.onCleared()
    }
}

data class FilmViewState(
    val shouldShowLoadingState: Boolean = false,
    val weatherTitle: String? = null,
    val weatherDescription: String? = null,
    val popularFilms: List<Film>? = null
)