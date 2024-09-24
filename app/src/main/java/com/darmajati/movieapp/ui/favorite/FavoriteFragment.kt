package com.darmajati.movieapp.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.darmajati.movieapp.databinding.FragmentFavoriteBinding
import com.darmajati.movieapp.model.Movie

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var favoriteMoviesAdapter: FavoriteMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // ViewModel setup
        favoriteViewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)

        // RecyclerView setup
        favoriteMoviesAdapter = FavoriteMoviesAdapter(emptyList())
        binding.recyclerViewFavoriteMovies.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewFavoriteMovies.adapter = favoriteMoviesAdapter

        // Observe ViewModel
        favoriteViewModel.favoriteMovies.observe(viewLifecycleOwner) { favoriteMovies ->
            if (favoriteMovies.isNullOrEmpty()) {
                binding.recyclerViewFavoriteMovies.visibility = View.GONE
                binding.textEmptyFavorites.visibility = View.VISIBLE
            } else {
                binding.recyclerViewFavoriteMovies.visibility = View.VISIBLE
                binding.textEmptyFavorites.visibility = View.GONE
                favoriteMoviesAdapter.updateMovies(favoriteMovies)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
