package com.mj.espressouitestexample.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mj.espressouitestexample.R
import com.mj.espressouitestexample.databinding.FragmentMovieDetailBinding
import com.mj.espressouitestexample.ui.data.Movie
import com.mj.espressouitestexample.ui.data.source.MoviesRemoteDataSource

class MovieDetailFragment : Fragment(){

    private lateinit var movie: Movie

    /**
     * In production the MoviesRemoteDataSource would be either:
     * 1) Be injected with a DI framework like dagger
     * 2) Be passed as a constructor param to the Fragment (if using FragmentFactory)
     * This is a simple use case so I'm just writing it here.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getInt("movie_id").let{ movieId ->
                MoviesRemoteDataSource.getMovie(movieId)?.let{ movieFromRemote ->
                    movie = movieFromRemote
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMovieDetails(view)

        view.findViewById<TextView>(R.id.movie_directiors).setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_directors", movie.directors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, DirectorsFragment::class.java, bundle)
                ?.addToBackStack("DirectorsFragment")
                ?.commit()
        }

        view.findViewById<TextView>(R.id.movie_star_actors).setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_actors", movie.star_actors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, StarActorsFragment::class.java, bundle)
                ?.addToBackStack("StarActorsFragment")
                ?.commit()
        }
    }

    private fun setMovieDetails(view: View){
        movie.let{ nonNullMovie ->
            Glide.with(this)
                .load(nonNullMovie.image)
                .into(view.findViewById<ImageView>(R.id.movie_image))

            view.findViewById<TextView>(R.id.movie_title).text = nonNullMovie.title
            view.findViewById<TextView>(R.id.movie_description).text = nonNullMovie.description
        }
    }

}

















