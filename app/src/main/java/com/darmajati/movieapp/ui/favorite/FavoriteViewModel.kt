package com.darmajati.movieapp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.darmajati.movieapp.model.Movie
import com.darmajati.movieapp.R

class FavoriteViewModel : ViewModel() {

    private val _favoriteMovies = MutableLiveData<List<Movie>>()
    val favoriteMovies: LiveData<List<Movie>> = _favoriteMovies

    init {

        _favoriteMovies.value = listOf(
            Movie("Inception", "A mind-bending thriller", R.drawable.avengers),
            Movie("The Matrix", "A hacker discovers reality", R.drawable.avengers)
        )
    }
}
