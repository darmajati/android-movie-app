package com.darmajati.movieapp.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.darmajati.movieapp.LoginActivity
import com.darmajati.movieapp.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!
    private lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // ViewModel setup
        accountViewModel = ViewModelProvider(this).get(AccountViewModel::class.java)

        // Display account info
        accountViewModel.accountInfo.observe(viewLifecycleOwner) {
            binding.textAccountInfo.text = it
        }

        // Handle logout button click
        binding.buttonLogout.setOnClickListener {
            // Perform logout action (e.g., clear user session)
            logoutUser()

            // Navigate to login activity
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish() // Close current activity
        }

        return root
    }

    private fun logoutUser() {
        // Logic to clear user session or token
        // Example: clear shared preferences or any session management
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
