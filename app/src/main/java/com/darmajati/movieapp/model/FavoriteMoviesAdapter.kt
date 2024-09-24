package com.darmajati.movieapp.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.darmajati.movieapp.databinding.ItemFavoriteMovieBinding
import com.darmajati.movieapp.model.Movie

class FavoriteMoviesAdapter(
    private var favoriteMovies: List<Movie>
) : RecyclerView.Adapter<FavoriteMoviesAdapter.FavoriteMoviesViewHolder>() {

    inner class FavoriteMoviesViewHolder(private val binding: ItemFavoriteMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.textMovieTitle.text = movie.title
            binding.textMovieInfo.text = movie.info
            binding.imageMoviePoster.setImageResource(movie.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMoviesViewHolder {
        val binding = ItemFavoriteMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FavoriteMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteMoviesViewHolder, position: Int) {
        holder.bind(favoriteMovies[position])
    }

    override fun getItemCount(): Int = favoriteMovies.size

    fun updateMovies(movies: List<Movie>) {
        this.favoriteMovies = movies
        notifyDataSetChanged()
    }
}
