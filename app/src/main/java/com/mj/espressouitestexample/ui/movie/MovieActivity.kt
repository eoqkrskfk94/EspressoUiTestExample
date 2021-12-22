package com.mj.espressouitestexample.ui.movie

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.RequestOptions
import com.mj.espressouitestexample.R
import com.mj.espressouitestexample.UICommunicationListener
import com.mj.espressouitestexample.ui.data.source.MoviesDataSource
import com.mj.espressouitestexample.ui.data.source.MoviesRemoteDataSource
import com.mj.espressouitestexample.ui.factory.MovieFragmentFactory

class MovieActivity : AppCompatActivity(),
    UICommunicationListener {

    override fun loading(isLoading: Boolean) {
        if (isLoading)
            findViewById<ProgressBar>(R.id.progress_bar).visibility = View.VISIBLE
        else
            findViewById<ProgressBar>(R.id.progress_bar).visibility = View.INVISIBLE
    }


    // dependencies (typically would be injected with dagger)
    lateinit var requestOptions: RequestOptions
    lateinit var moviesDataSource: MoviesDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = MovieFragmentFactory(
            requestOptions,
            moviesDataSource
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieListFragment::class.java, null)
                .commit()
        }
    }

    private fun initDependencies(){
        if(!::requestOptions.isInitialized){
            // glide
            requestOptions = RequestOptions
                .placeholderOf(R.drawable.default_image)
                .error(R.drawable.default_image)
        }
        if(!::moviesDataSource.isInitialized){
            // Data Source
            moviesDataSource = MoviesRemoteDataSource()
        }
    }

}







