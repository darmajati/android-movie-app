package com.darmajati.movieapp.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.darmajati.movieapp.R

class TopRatedMovieAdapter(private val movies: List<TopRatedMovie>) : RecyclerView.Adapter<TopRatedMovieAdapter.TopRatedMovieViewHolder>() {

    class TopRatedMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.movie_title)
        val yearTextView: TextView = itemView.findViewById(R.id.movie_year_release)
        val ratingTextView: TextView = itemView.findViewById(R.id.movie_rating)
        val infoTextView: TextView = itemView.findViewById(R.id.movie_info)
        val imageView: ImageView = itemView.findViewById(R.id.movie_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_rated_movie, parent, false)
        return TopRatedMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopRatedMovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleTextView.text = movie.title
        holder.yearTextView.text = movie.releaseYear
        holder.ratingTextView.text = movie.rating
        holder.infoTextView.text = movie.info
        holder.imageView.setImageResource(movie.imageResId)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}