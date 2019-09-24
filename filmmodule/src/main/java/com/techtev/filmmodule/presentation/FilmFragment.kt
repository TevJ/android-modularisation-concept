package com.techtev.filmmodule.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.*
import com.techtev.coremodule.annotations.FilmType
import com.techtev.coremodule.base.BaseFragment
import com.techtev.filmbinder.Film
import com.techtev.filmmodule.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_film.*
import kotlinx.android.synthetic.main.fragment_film.view.*
import kotlinx.android.synthetic.main.list_item_film.view.*
import javax.inject.Inject

class FilmFragment : BaseFragment() {

    @Inject @field:FilmType
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val filmAdapter = FilmAdapter()

    private lateinit var viewModel: FilmViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_film, container, false).apply {
            setupRecyclerView()
        }
    }

    private fun View.setupRecyclerView() {
        rv_popular_films.apply {
            adapter = filmAdapter
            layoutManager = LinearLayoutManager(context)
            val divider = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
            addItemDecoration(divider)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = viewModelFactory.create(FilmViewModel::class.java).apply {
            viewState.observe(viewLifecycleOwner, Observer(::renderViewState))
            onScreenStart()
        }
    }

    private fun renderViewState(viewState: FilmViewState?) {
        viewState?.apply {
            tv_weather_info.text = "${viewState.weatherTitle}\n${viewState.weatherDescription}"
            filmAdapter.submitList(popularFilms ?: listOf())
        }
    }
}

class FilmAdapter: ListAdapter<Film, ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.list_item_film, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Film>() {
            override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    fun bind(film: Film) {
        containerView.apply {
            tv_film_title.text = film.title
            tv_film_description.text = film.overview
        }
    }
}