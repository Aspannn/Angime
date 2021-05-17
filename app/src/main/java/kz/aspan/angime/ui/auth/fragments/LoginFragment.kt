package kz.aspan.angime.ui.auth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import kz.aspan.angime.R
import kz.aspan.angime.other.EventObserver
import kz.aspan.angime.ui.auth.AuthViewModel
import kz.aspan.angime.ui.main.MainActivity
import kz.aspan.angime.ui.snackbar

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)
        subscribeToObservers()

        btnLogin.setOnClickListener {
            viewModel.login(
                etEmail.text.toString(),
                etPassword.text.toString()
            )
        }

        tvRegisterNewAccount.setOnClickListener {
            if (findNavController().previousBackStackEntry != null) {
                findNavController().popBackStack()
            } else findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            )
        }

    }

    private fun subscribeToObservers() {
        viewModel.loginStatus.observe(
            viewLifecycleOwner, EventObserver(
                onError = {
                    loginProgressBar.isVisible = false
                    snackbar(it)
                },
                onLoading = { loginProgressBar.isVisible = true }
            ) {
                loginProgressBar.isVisible = false
                Intent(requireContext(), MainActivity::class.java).also {
                    startActivity(it)
                    requireActivity().finish()
                }
            }
        )
    }

}