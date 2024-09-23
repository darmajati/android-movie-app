package com.darmajati.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.darmajati.movieapp.databinding.FragmentHomeBinding
import com.darmajati.movieapp.model.Movie
import com.darmajati.movieapp.model.MovieAdapter
import com.darmajati.movieapp.R
import com.darmajati.movieapp.model.TopRatedMovie
import com.darmajati.movieapp.model.TopRatedMovieAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerViewNowPlaying: RecyclerView = binding.recyclerNowPlaying
        recyclerViewNowPlaying.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val recyclerViewPopular: RecyclerView = binding.recyclerPopular
        recyclerViewPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val recyclerViewTopRated: RecyclerView = binding.recyclerTopRated
        recyclerViewTopRated.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val movies = listOf(
            Movie("Title 1", "Info 1",  R.drawable.avengers),
            Movie("Title 2", "Info 2",  R.drawable.avengers),
            Movie("Title 3", "Info 3",  R.drawable.avengers),
            Movie("Title 4", "Info 4",  R.drawable.avengers),
            Movie("Title 5", "Info 5",  R.drawable.avengers),
            Movie("Title 6", "Info 6",  R.drawable.avengers)
        )

        val topRatedMovies = listOf(
            TopRatedMovie("Title 1", "2010-09-29", "8.5/10", "Info 1",  R.drawable.avengers),
            TopRatedMovie("Title 2", "2010-09-29", "8/10", "Info 2",  R.drawable.avengers),
            TopRatedMovie("Title 3", "2010-09-29", "7.5/10", "Info 3",  R.drawable.avengers),
            TopRatedMovie("Title 4", "2010-09-29", "9.5/10", "Info 4",  R.drawable.avengers),
            TopRatedMovie("Title 5", "2010-09-29", "8.5/10", "Info 5",  R.drawable.avengers),
            TopRatedMovie("Title 6", "2010-09-29", "9/10", "Info 6",  R.drawable.avengers)
        )

        val adapter = MovieAdapter(movies)
        recyclerViewNowPlaying.adapter = adapter
        recyclerViewPopular.adapter = adapter

        val topRatedAdapter = TopRatedMovieAdapter(topRatedMovies)
        recyclerViewTopRated.adapter = topRatedAdapter


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}