package com.mj.espressouitestexample.ui.data.source

import com.mj.espressouitestexample.ui.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}